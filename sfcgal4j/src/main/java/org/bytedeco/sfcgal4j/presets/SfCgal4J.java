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
        target = "org.bytedeco.sfcgal4j",
        global = "org.bytedeco.sfcgal4j.global.SFCGAL_BaseGeometries",
        value = {
                @Platform(define = "SFCGAL_API",link = {"SFCGAL"},
                        resource = {"include"},
                        include = {
                                "SFCGAL/Coordinate.h",
                                "SFCGAL/Envelope.h",
                                "SFCGAL/Exception.h",
                                "SFCGAL/export.h",
                                "SFCGAL/GeometryCollection.h",
                                "SFCGAL/Geometry.h",
                                "SFCGAL/GeometryVisitor.h",
                                "SFCGAL/Kernel.h",
                                "SFCGAL/LineString.h",
                                "SFCGAL/MultiLineString.h",
                                "SFCGAL/MultiPoint.h",
                                "SFCGAL/MultiPolygon.h",
                                "SFCGAL/MultiSolid.h",
                                "SFCGAL/numeric.h",
                                "SFCGAL/Point.h",
                                "SFCGAL/Polygon.h",
                                "SFCGAL/PolyhedralSurface.h",
                                "SFCGAL/PreparedGeometry.h",
                                "SFCGAL/Solid.h",
                                "SFCGAL/Surface.h",
                                "SFCGAL/Transform.h",
                                "SFCGAL/Triangle.h",
                                "SFCGAL/TriangulatedSurface.h",
                                "SFCGAL/Validity.h",
                                "SFCGAL/version.h",
                        }),
                @Platform(
                        value = {"linux"},
                        link = {"SFCGAL"}
                )}
)
public class SfCgal4J implements InfoMapper {
    static { Loader.checkVersion("org.bytedeco", "sfcgal4j"); }

    public void map(InfoMap infoMap) {
        infoMap
                .put(new Info("SFCGAL_API").cppTypes().annotations())
                .put(new Info("CGAL::Exact_predicates_exact_constructions_kernel").pointerTypes("CGAL_Kernel"))
                .put(new Info("Kernel::FT").pointerTypes("float"))
                .put(new Info("Kernel::RT").pointerTypes("float"))
                .put(new Info("CGAL::Gmpq").javaNames("Gmpq"))
                .put(new Info("CGAL::Gmpz").javaNames("Gmpz"))
                .put(new Info("Kernel::Point_3").javaNames("CGAL.Kernel.Point_3"))
                .put(new Info("Kernel::Point_2").javaNames("CGAL.Kernel.Point_2"))
                .put(new Info("Kernel::Vector_2").javaNames("CGAL.Kernel.Vector_2"))
                .put(new Info("Kernel::Vector_3").javaNames("CGAL.Kernel.Vector_3"))




        ;
    }

}
