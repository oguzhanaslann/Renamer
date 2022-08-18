import java.io.File;

public class Renamer {
    public static final String PATH_OF_DIR = "/Users/oguzhanaslan/AndroidStudioProjects/sample_avatars";
    public static final String FILE_MIME_TYPE = ".jpeg";
    public static final String RENAME_TEMPLATE = "ic_avatar_<x>"+ FILE_MIME_TYPE ;

    public static void main(String[] args) {
        File file = new File(PATH_OF_DIR);

        if (!file.exists()) throw new IllegalArgumentException("File DNE!");
        if (!file.isDirectory()) throw new IllegalArgumentException("File is not a directory");
        File[] files = file.listFiles();
        System.out.println(files.length);
        for (int childIndex = 0; childIndex < files.length; childIndex++) {
            File child = files[childIndex];
            String fileNewName = RENAME_TEMPLATE.replace("<x>",Integer.toString(childIndex));
            File newNamedFile = new File(PATH_OF_DIR+"/"+ fileNewName);
            child.renameTo(newNamedFile);
        }
    }
}
