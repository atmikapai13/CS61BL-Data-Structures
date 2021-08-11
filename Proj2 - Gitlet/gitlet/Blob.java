package gitlet;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class Blob implements Serializable {

    public String file_name;
    public String contents;
    private final byte[] byte_contents;
    public String sha_name;
    public Boolean new_file = true;
    public HashMap<String, String> names = new HashMap<>();
    public String trunc_sha;


    public Blob(String name, File f) {
        this.file_name = name;
        this.contents = Utils.readContentsAsString(f);
        this.byte_contents = Utils.readContents(f);
        this.write_blob_obj();
    }

    public void write_blob_obj() {
        this.sha_name = Repository.get_sha(this);
        this.truncated_sha();
        this.names.put(file_name, sha_name);
        File a_blob_file = Utils.join(Repository.BLOB, sha_name);
        Utils.writeObject(a_blob_file, this);
    }

    private void truncated_sha() {
        this.trunc_sha = this.sha_name.substring(0, 6);
    }

    @Override
    public boolean equals(Object o) {
        Blob obj = (Blob) o;
        return (trunc_sha.equals(obj.trunc_sha));
    }

    public boolean compare_blob(Blob b1, Blob b2) {
        return b1.trunc_sha.equals(b2.trunc_sha);
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


}
