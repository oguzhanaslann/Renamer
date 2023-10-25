import org.jetbrains.annotations.NotNull;

public class TemplateIndexedRenameStrategy  implements  RenameStrategy {
    public static final String FILE_MIME_TYPE = ".png";
    public static final String RENAME_TEMPLATE = "ic_empty_avatar_<x>" + FILE_MIME_TYPE;

    @Override
    public String rename(String fileName, int index) {
        return RENAME_TEMPLATE.replace("<x>", suffixOfFile(index));
    }

    @NotNull
    private static CharSequence suffixOfFile(int childIndex) {
        return "x" + (childIndex + 1);
    }
}
