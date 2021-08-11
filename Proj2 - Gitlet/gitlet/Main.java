package gitlet;

<<<<<<< HEAD
import java.io.*;

=======
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author TODO
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
<<<<<<< HEAD


    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please enter a command.");
            System.exit(0);
        }
        String firstArg = args[0];
        String[] restArg = new String[args.length-1];
        System.arraycopy(args, 1, restArg, 0, args.length-1);
        switch(firstArg) {
            case "init":
                validateArgs(restArg, 0);
                Repository.init();
                break;
            case "add":
                git_exists();
                validateArgs(restArg, 1);
                Repository.add(restArg[0]);
                break;
            case "commit":
                git_exists();
                if (restArg.length > 1 || restArg[0].equals("")){
                    System.out.println(restArg[0]);
                    System.out.println("Please enter a commit message.");
                }
                Repository.commit(restArg[0]);
                break;
            case "checkout":
                git_exists();
                if ((restArg.length == 2) && restArg[0].equals("--")) {
                    Repository.checkout(Repository.get_master(), restArg[1]);
                } else if ((restArg.length == 3) && restArg[1].equals("--")) {
                    Repository.checkout(restArg[0], restArg[2]);
                } else {
                    validateArgs(restArg, 1);
                    if (restArg[0].equals(Repository.get_head())) {
                        System.out.println("No need to checkout the current branch.");
                        System.exit(0);
                    } if (!Utils.join(Repository.BRANCHES, restArg[0]).exists()) {
                        System.out.println("No such branch exists.");
                        System.exit(0);
                    }
                    Repository.checkout_branch(restArg[0]);
                }
                break;
            case "log":
                git_exists();
                validateArgs(restArg, 0);
                Repository.log();
                break;
            case "rm":
                git_exists();
                validateArgs(restArg, 1);
                Repository.rm(restArg[0]);
                break;
            case "global-log":
                git_exists();
                validateArgs(restArg, 0);
                Repository.global_log();
                break;
            case "find":
                git_exists();
                validateArgs(restArg, 1);
                Repository.find(restArg[0]);
                break;
            case "status":
                git_exists();
                validateArgs(restArg, 0);
                Repository.status();
                break;
            case "branch":
                git_exists();
                validateArgs(restArg, 1);
                if (Repository.does_file_exist(Repository.BRANCHES, restArg[0])) {
                    System.out.println("A branch with that name already exists.");
                } else Repository.branch(restArg[0]);
                break;
            case "rm-branch":
                git_exists();
                validateArgs(restArg, 1);
                if (Repository.does_file_exist(Repository.BRANCHES, restArg[0]) == false) {
                    System.out.println("A branch with that name does not exist.");
                } else if (Repository.get_head().equals(restArg[0])) {
                    System.out.println("Cannot remove the current branch.");
                } else Repository.rm_branch(restArg[0]);
                break;
            case "reset":
                git_exists();
                validateArgs(restArg, 1);
                if (!Repository.does_file_exist(Repository.COMMITS, restArg[0])) {
                    System.out.println("No commit with that id exists.");
                } else Repository.reset(restArg[0]);
                break;
            default:
                git_exists();
                System.out.println("No command with that name exits");
                System.exit(0);
        }
    }

    public static void validateArgs(String[] args, int n) {
        if (args.length != n) {
            System.out.println("Incorrect operands.");
            System.exit(0);
        }
    }

    public static void git_exists() {
        if (!Repository.GITLET_DIR.exists()) {
            System.out.println("Not in an initialized Gitlet directory.");
            System.exit(0);
        }
    }

=======
    public static void main(String[] args) {
        // TODO: what if args is empty?
        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                // TODO: handle the `init` command
                break;
            case "add":
                // TODO: handle the `add [filename]` command
                break;
            // TODO: FILL THE REST IN
        }
    }
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
}
