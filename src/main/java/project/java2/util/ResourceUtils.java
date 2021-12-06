package project.java2.util;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * 以resource为 ./ 目录
 */
public class ResourceUtils {
    public static Path getResourcePath(String relativePath) throws URISyntaxException {
        return Paths.get(Objects.requireNonNull(getResourceUrl(relativePath)).toURI());
    }

    public static URL getResourceUrl(String relativePath) throws URISyntaxException {
        return ResourceUtils.class.getResource("/" + relativePath);
    }
}
