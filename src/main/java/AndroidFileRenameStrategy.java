public class AndroidFileRenameStrategy implements RenameStrategy {
    public static final String ANDROID_FILE_REGEX = "^[a-z0-9_]+$";

    @Override
    public String rename(String fileName, int index) {
        String updatedFileName = fileName.replace("-", "_");
        return updatedFileName.toLowerCase().replace(" ", "_");
    }
}
