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
        target = "org.bytedeco.sfcgal4j.algorithm",
        global = "org.bytedeco.sfcgal4j.global.SFAlgorithm",
        value = {
                @Platform(define = "SFCGAL_API",link = {"SFCGAL"},
                        resource = {"include"},
                        include = { "SFCGAL/algorithm/area.h",
                                "SFCGAL/algorithm/BoundaryVisitor.h",
                                "SFCGAL/algorithm/collect.h",
                                "SFCGAL/algorithm/collectionExtract.h",
                                "SFCGAL/algorithm/collectionHomogenize.h",
                                "SFCGAL/algorithm/collectionToMulti.h",
                                "SFCGAL/algorithm/connection.h",
                                "SFCGAL/algorithm/ConsistentOrientationBuilder.h",
                                "SFCGAL/algorithm/convexHull.h",
                                "SFCGAL/algorithm/covers.h",
                                "SFCGAL/algorithm/difference.h",
                                "SFCGAL/algorithm/differencePrimitives.h",
                                "SFCGAL/algorithm/distance3d.h",
                                "SFCGAL/algorithm/distance.h",
                                "SFCGAL/algorithm/extrude.h",
                                "SFCGAL/algorithm/force2D.h",
                                "SFCGAL/algorithm/force3D.h",
                                "SFCGAL/algorithm/intersection.h",
                                "SFCGAL/algorithm/intersects.h",
                                "SFCGAL/algorithm/isValid.h",
                                "SFCGAL/algorithm/length.h",
                                "SFCGAL/algorithm/lineSubstring.h",
                                "SFCGAL/algorithm/minkowskiSum.h",
                                "SFCGAL/algorithm/normal.h",
                                "SFCGAL/algorithm/offset.h",
                                "SFCGAL/algorithm/orientation.h",
                                "SFCGAL/algorithm/plane.h",
                                "SFCGAL/algorithm/straightSkeleton.h",
                                "SFCGAL/algorithm/tesselate.h",
                                "SFCGAL/algorithm/translate.h",
                                "SFCGAL/algorithm/union.h",
                                "SFCGAL/algorithm/volume.h"

                        }),
                @Platform(
                        value = {"linux"},
                        link = {"SFCGAL"}
                )}
)
public class SFAlgorithm implements InfoMapper {
    static {
        Loader.checkVersion("org.bytedeco", "sfcgal4j");
    }

    public void map(InfoMap infoMap) {
        infoMap.put(new Info("SFCGAL_API").cppTypes().annotations());

    }
}
