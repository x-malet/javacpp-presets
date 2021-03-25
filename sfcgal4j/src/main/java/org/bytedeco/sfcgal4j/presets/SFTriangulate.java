package org.bytedeco.sfcgal4j.presets;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.presets.javacpp;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

@Properties(
        inherit = javacpp.class,
        target = "org.bytedeco.sfcgal4j.triangulate",
        global = "org.bytedeco.sfcgal4j.global.SFTriangulate",
        value = {
                @Platform(define = "SFCGAL_API", link = {"SFCGAL"},
                        resource = {"include"},
                        include = {
                                "SFCGAL/triangulate/triangulatePolygon.h",
                                "SFCGAL/triangulate/triangulate2DZ.h",
                        })})
public class SFTriangulate implements InfoMapper {
    static {
        Loader.checkVersion("org.bytedeco", "sfcgal4j");
    }

    public void map(InfoMap infoMap) {
        infoMap.put(new Info("SFCGAL_API").cppTypes().annotations());

    }
}
