import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Renamer {
    public static final String PATH_OF_DIR = "/Users/oguzhanmac/Desktop/empty_state_avatar";

    public static void main(String[] args) {
        File file = new File(PATH_OF_DIR);

        if (!file.exists()) throw new IllegalArgumentException("File DNE!");
        if (!file.isDirectory()) throw new IllegalArgumentException("File is not a directory");
        File[] files = file.listFiles();
        System.out.println(files.length);
        Stream<File> fileStream = Arrays.stream(files).sorted((o1, o2) -> {
                    long o1Length = o1.length();
                    long o2Length = o2.length();
                    return Long.compare(o1Length, o2Length);
                }
        );

        AtomicInteger childIndex = new AtomicInteger();
        fileStream.forEach((child -> {
            File newNamedFile = androidNamedFile(childIndex, child);
            child.renameTo(newNamedFile);
            childIndex.getAndIncrement();
        }));

    }

    @NotNull
    private static File indexedNamedFile(AtomicInteger childIndex, File child) {
        TemplateIndexedRenameStrategy renameStrategy = new TemplateIndexedRenameStrategy();
        String fileNewName= renameStrategy.rename(child.getName(), childIndex.get());
        return new File(PATH_OF_DIR + "/" + fileNewName);
    }


    @NotNull
    private static File androidNamedFile(AtomicInteger childIndex, File child) {
        AndroidFileRenameStrategy renameStrategy = new AndroidFileRenameStrategy();
        String fileNewName = renameStrategy.rename(child.getName(), childIndex.get());
        return new File(PATH_OF_DIR + "/" + fileNewName);
    }
}
