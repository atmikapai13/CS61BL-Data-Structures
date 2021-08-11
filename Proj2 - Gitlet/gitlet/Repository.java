package gitlet;
<<<<<<< HEAD
import java.io.*;
import java.util.*;

import static gitlet.Utils.*;

=======

import java.io.File;
import static gitlet.Utils.*;

// TODO: any imports you need here

>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
/** Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
<<<<<<< HEAD
 *  @author AP
 */
public class Repository implements Serializable {
    /**
=======
 *  @author TODO
 */
public class Repository {
    /**
     * TODO: add instance variables here.
     *
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
<<<<<<< HEAD

    /** The .gitlet directory. */
    public static final File GITLET_DIR = Utils.join(CWD, ".gitlet");

    //directories
    public static final File COMMITS = Utils.join(GITLET_DIR, "commits");
    public static final File STAGING = Utils.join(GITLET_DIR, "staging");
    public static final File ADD = Utils.join(STAGING, "staging_add");
    public static final File REMOVE = Utils.join(STAGING, "staging_remove");
    public static final File BRANCHES = Utils.join(GITLET_DIR, "branches");
    public static final File BLOB = Utils.join(GITLET_DIR, "blobs");

    //files
    public static final File MASTER = Utils.join(BRANCHES, "master");
    public static final File HEAD = Utils.join(BRANCHES, "head");
    public static File f = null;

    public static void init() {
        if (GITLET_DIR.exists()) {
            System.out.println("A Gitlet version-control system already exists in the current directory.");
            System.exit(0);
        }
        GITLET_DIR.mkdir();
        COMMITS.mkdir();
        STAGING.mkdir();
        ADD.mkdir();
        REMOVE.mkdir();
        BRANCHES.mkdir();
        BLOB.mkdir();
        try {
            HEAD.createNewFile();
            MASTER.createNewFile();
        } catch (IOException e) {
        }

        //Head points to master
        writeContents(HEAD, "master");

        //Create initial commit
        Commit initial_commit = new Commit("initial commit", null, null);

        //Create a pointer to a file in commits with the sha of initial commit
        File file_name = Utils.join(COMMITS, get_sha(initial_commit));
        Utils.writeObject(file_name, initial_commit);

        //Write the latest commit to master file
        Utils.writeContents(MASTER, get_sha(initial_commit));
    }


    //Adds a file to the staging area
    public static void add(String file_name) {
        if (Utils.join(file_name).exists()) {
            Blob new_blob = new Blob(file_name, Utils.join(CWD, file_name));
            Commit prev_commit = get_commit(get_master());
            if (Utils.join(REMOVE, file_name).exists()) {
                Utils.join(REMOVE, file_name).delete();
            }
            if (prev_commit.tracked_blobs.containsKey(file_name) && new_blob.sha_name.equals(prev_commit.tracked_blobs.get(file_name))) {
                if (does_file_exist(ADD, file_name)) {
                    File f = Utils.join(ADD, file_name);
                    f.delete();
                }
                System.exit(0);
            } else {
                Utils.writeContents(Utils.join(ADD, new_blob.file_name), new_blob.sha_name);
            }
        } else {
            System.out.println("File does not exist.");
        }
    }

    //Commits files and persists through commits directory
    public static void commit(String msg) {
        List<String> files_to_add = plainFilenamesIn(ADD);
        List<String> files_to_remove = plainFilenamesIn(REMOVE);

        if (files_to_add.size() == 0 && files_to_remove.size() == 0) {
            System.out.println("No changes added to the commit");
            System.exit(0);
        } else {
            HashMap<String, String> new_tracked_blobs = new HashMap<>();
            HashMap prev_commit = get_commit(get_master()).tracked_blobs;

            for (int i = 0; i < files_to_add.size(); i++) {
                File f = join(ADD, files_to_add.get(i));
                new_tracked_blobs.put(files_to_add.get(i), readContentsAsString(f));
                f.delete();
            }

            for (int i = 0; i < files_to_remove.size(); i++) {
                if (prev_commit.containsKey(files_to_remove.get(i))) {
                    Utils.join(REMOVE, files_to_remove.get(i)).delete();
                    Utils.join(CWD, files_to_remove.get(i)).delete();
                }
            }

            Commit new_commit = new Commit(msg, get_master(), new_tracked_blobs);
            writeObject(join(COMMITS, get_sha(new_commit)), new_commit);
            writeContents(Utils.join(BRANCHES, get_head()), get_sha(new_commit));
        }
    }

    //Checkout a specific file in a commit
    public static void checkout(String commit_sha, String file_name) {
        try {
            Commit commit = get_commit(commit_sha);
            HashMap<String, String> tracked_blobs = get_commit(get_master()).tracked_blobs;
            if (tracked_blobs.containsKey(file_name)) {
                Utils.writeContents(Utils.join(CWD, file_name), get_blob(commit.tracked_blobs.get(file_name)).contents);
            } else System.out.println("File does not exist in that commit.");
        }
        catch (IllegalArgumentException e) {
            System.out.println("No commit with that id exists.");
        }
    }

    public static void checkout_branch(String branch_name) {
        untracked_files_exist();
        writeContents(HEAD, branch_name);
        List<String> files_CWD = plainFilenamesIn(CWD);
        for (String f: files_CWD) {
            Utils.join(CWD, f).delete();
        }
        HashMap<String, String> tracked_blobs = get_commit(get_master()).tracked_blobs;
        if (!tracked_blobs.containsKey(null)) {
            for (Map.Entry blob : tracked_blobs.entrySet()) {
                f = Utils.join(CWD, (String) blob.getKey());
                try {
                    f.createNewFile();
                } catch (IOException e) { }
                writeContents(f, get_blob((String) blob.getValue()).contents);
            }
        }
    }

    public static void rm(String file_name) {
        HashMap prev_commit = get_commit(get_master()).tracked_blobs;
        if (Utils.join(ADD, file_name).exists()) {
            Utils.join(ADD, file_name).delete();
            //writeContents(Utils.join(REMOVE, file_name), prev_commit.get(file_name));
        } else if (prev_commit.containsKey(file_name)) {
            writeContents(Utils.join(REMOVE, file_name), prev_commit.get(file_name));
            Utils.join(CWD, file_name).delete();
        } else System.out.println("No reason to remove the file.");
    }

    public static void rm_branch(String branch_name) {
        File f = Utils.join(BRANCHES, branch_name);
        f.delete();
    }

    public static void find(String commit_message) {
        List<String> all_commits = plainFilenamesIn(COMMITS);
        Boolean print_out = false;
        for (String com : all_commits) {
            if (get_commit(com).message.equals(commit_message)) {
                System.out.println(com);
                print_out = true;
            }
        } if (print_out == false) System.out.println("Found no commit with that message.");
    }

    public static void branch(String branch_name) {
        File NEW_BRANCH = Utils.join(BRANCHES, branch_name);
        if (!NEW_BRANCH.exists()) {
            try {
                NEW_BRANCH.createNewFile();
                writeContents(NEW_BRANCH, get_master());
            } catch (IOException e) {
            }
        } else writeContents(NEW_BRANCH, get_master());
    }

    public static void status(){
        HashMap<String, File> status = new HashMap<>();
        String[] file = new String[]{"Branches", "Staged Files", "Removed Files"};
        File[] dirs = new File[]{BRANCHES, ADD, REMOVE};

        for (int i = 0; i < file.length; i++) {
            System.out.println("=== "+file[i]+" ===");
            status_helper((File) dirs[i]);
        }
        System.out.println("=== Modifications Not Staged For Commit ==="+"\n");
        System.out.println("=== Untracked Files ==="+"\n");
    }

    public static void status_helper(File dir) {
        List<String> files = plainFilenamesIn(dir);
        for (int i = 0; i < files.size(); i++) {
            if (files.get(i).equals(get_head())) {
                System.out.println("*" + files.get(i));
            } else if (files.get(i).equals("head")) {
                continue;
            } else {
                System.out.println(files.get(i));
            }
        }
        System.out.println();
    }

    public static void reset(String commit_id) {
        untracked_files_exist();
        HashMap<String, String> tracked_blobs = get_commit(commit_id).tracked_blobs;
        writeContents(Utils.join(BRANCHES, get_head()), commit_id);
        for (Map.Entry blob : tracked_blobs.entrySet()) {
            writeContents(Utils.join(CWD, (String) blob.getKey()), get_blob((String) blob.getValue()).contents);
        }
        List<String> staged_files = plainFilenamesIn(ADD);
        for (String s : staged_files) {
            Utils.join(ADD, s).delete();
        }
    }



    //Prints log
    public static void log() {
        Commit commit = get_commit(get_master());
        while (commit != null) {
            commit.print_helper();
            if (commit.parent != null) {
                commit = get_commit(commit.parent);
            } else commit = null;
        }
    }

    public static void global_log() {
        List<String> commits = plainFilenamesIn(COMMITS);
        for (String commit : commits) {
            get_commit(commit).print_helper();
        }
    }


    //Gets the latest commit to pass as parent into a new commit
    public static String get_master() {
        File f = Utils.join(BRANCHES, get_head());
        return Utils.readContentsAsString(f);
    }

    //Gets head pointer
    public static String get_head() {
        return readContentsAsString(HEAD);
    }

    //Gets blob object
    public static Blob get_blob(String sha_value) {
        return readObject(join(BLOB, sha_value), Blob.class);
    }

    //Gets commit object
    public static Commit get_commit(String sha_value) {
        return readObject(Utils.join(Repository.COMMITS, sha_value), Commit.class);
    }

    //Gets a sha-Value for a serializable object
    public static String get_sha(Serializable obj) {
        return Utils.sha1(Utils.serialize(obj));
    }

    public static Boolean does_file_exist(File directory, String name_of_file) {
        File f = Utils.join(directory, name_of_file);
        if (f.exists()) {
            return true;
        } else return false;
    }

    /**
    public static void untracked_files_exist() {
        List<String> untracked = plainFilenamesIn(CWD);
        List<String> tracked = plainFilenamesIn(ADD);
        tracked.addAll(plainFilenamesIn(REMOVE));
        if (tracked.size() > 0) {
            for (String file : untracked) {
                if (tracked.contains(file)) {
                    try {
                        untracked.remove(new String(file));
                    } catch (UnsupportedOperationException e) {
                    }
                }
            }
        }
        if (untracked.size() > 0) {
            Commit com = get_commit(get_master());
            HashMap tracked_blobs = com.tracked_blobs;
            while (tracked_blobs.containsKey(null) || tracked_blobs.size() > 0) {
                for (String file : untracked) {
                    if (tracked_blobs.containsKey(file)) {
                        try { untracked.remove(new String(file));
                        } catch (UnsupportedOperationException e) { }
                    }
                }
                if (com.parent == null) break;
                com = get_commit(com.parent);
            }
            if (untracked.size() > 0) {
                System.out.println("There is an untracked file in the way; delete it, or add and commit it first.");
                System.exit(0);
            }
        }
    }
    */

    public static void untracked_files_exist() {
        Set<String> untracked1 = new HashSet<>();
        List<String> untracked = plainFilenamesIn(CWD);
        List<String> tracked = plainFilenamesIn(ADD);
        tracked.addAll(plainFilenamesIn(REMOVE));
        try { untracked.removeAll(tracked);
        } catch (UnsupportedOperationException e) {
        }
        if (untracked.size() > 0) {
            for (String x : untracked) {
                untracked1.add(x);
            }
            Commit com = get_commit(get_master());
            Set<String> tracked_blobs = com.tracked_blobs.keySet();
            while (!tracked_blobs.contains(null)) {
                try { untracked1.removeAll(tracked_blobs);
                } catch (UnsupportedOperationException e) { }
                if (com.parent == null) break;
                com = get_commit(com.parent);
                tracked_blobs.clear();
                try { tracked_blobs.addAll(com.tracked_blobs.keySet());
                } catch (UnsupportedOperationException e) { }
            }
        }
        if (untracked1.size() > 0) {
            System.out.println("There is an untracked file in the way; delete it, or add and commit it first.");
            System.exit(0);
        }
    }

=======
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");

    /* TODO: fill in the rest of this class. */
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
}
