import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class RenamerTest {

    //File-based resource names must contain only lowercase a-z, 0-9, or underscore
    @Test
    void AndroidNamingTestValidNameGeneration() {

        List<String> names = List.of(
                "file-name",
                "Pascal-Case-Kebab-Case",
                "PascalCaseKebabCase",
                "DMSans_36pt-Italic",
                "Spaced named"
        );

        AndroidFileRenameStrategy renameStrategy = new AndroidFileRenameStrategy();
        names.forEach((fileName) -> {
            String fileRegex = AndroidFileRenameStrategy.ANDROID_FILE_REGEX;
            Pattern pattern = Pattern.compile(fileRegex);
            String actual = renameStrategy.rename(fileName, 0);
            assertTrue(pattern.matcher(actual).matches());
        });
    }

}