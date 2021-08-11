package gitlet;

// TODO: any imports you need here

<<<<<<< HEAD
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
=======
import java.util.Date; // TODO: You'll likely use this in this class
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
<<<<<<< HEAD
 *  @author AP
 */
public class Commit implements Serializable {

    String message;
    String parent;
    String timestamp;
    HashMap<String, String> tracked_blobs = new HashMap<>();

    /**
=======
 *  @author TODO
 */
public class Commit {
    /**
     * TODO: add instance variables here.
     *
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /** The message of this Commit. */
<<<<<<< HEAD

    public Commit(String msg, String parent, HashMap<String, String> files_to_be_tracked) {
        this.message = msg;
        this.parent = parent;
        if (parent == null) {
            this.timestamp = new SimpleDateFormat("E MMM d HH:mm:ss y Z").format(new Date(0));
            HashMap<String, String> parent_of_commit = new HashMap<String, String>();
            parent_of_commit.put(null, null);
            this.tracked_blobs = parent_of_commit;
        } else {
            this.timestamp = new SimpleDateFormat("E MMM d HH:mm:ss y Z").format(new Date());
            this.tracked_blobs = files_to_be_tracked;
        }
    }

    public String getMessage() {
        return this.message;
    }

    public String getParent() {
        return this.parent;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public HashMap<String, String> getTracked_blobs() {
        return this.tracked_blobs;
    }

    public void print_helper() {
        System.out.println("===");
        System.out.println("commit " + Repository.get_sha(this));
        System.out.println("Date: " + this.timestamp);
        System.out.println(this.message);
        System.out.println();
    }

    public String long_sha(Blob obj) {
        List<String> all_blobs = Utils.plainFilenamesIn(Repository.BLOB);
        for (String blob : all_blobs) {
            Blob blob1 = Repository.get_blob(blob);
            if (obj.equals(blob1)) {
                return blob1.sha_name;
            }
        }
        return obj.sha_name;
    }

=======
    private String message;

    /* TODO: fill in the rest of this class. */
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
}
