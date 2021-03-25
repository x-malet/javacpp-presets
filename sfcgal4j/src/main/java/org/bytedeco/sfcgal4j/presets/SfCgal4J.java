package org.bytedeco.sfcgal4j.presets;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.presets.javacpp;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

import java.util.Vector;

@Properties(
        inherit = javacpp.class,
        target = "org.bytedeco.sfcgal4j",
        global = "org.bytedeco.sfcgal4j.global.SFCGAL_BaseGeometries",
        value = {
                @Platform(define = "SFCGAL_API", link = {"SFCGAL"},
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
//                                "SFCGAL/LineString.h",
                                "SFCGAL/MultiLineString.h",
                                "SFCGAL/MultiPoint.h",
                                "SFCGAL/MultiPolygon.h",
                                "SFCGAL/MultiSolid.h",
//                                "SFCGAL/numeric.h",
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
    static {
        Loader.checkVersion("org.bytedeco", "sfcgal4j");
    }

    public void map(InfoMap infoMap) {
        infoMap
                .put(new Info("SFCGAL_API").cppTypes().annotations())
                .put(new Info("SFCGAL_API_TEMPLATE").cppTypes().annotations())
                .put(new Info("SFCGAL_API_TEMPLATE_EXPORT").define(true))

                .put(new Info("CGAL::Exact_predicates_exact_constructions_kernel").pointerTypes("CGAL_Kernel"))
                .put(new Info("Kernel::FT").pointerTypes("float"))
                .put(new Info("Kernel::RT").pointerTypes("float"))
                .put(new Info("CGAL::Gmpq").javaNames("Gmpq"))
                .put(new Info("CGAL::Gmpz").javaNames("Gmpz"))
                .put(new Info("SFCGAL::Point").pointerTypes("Point"))


                .put(new Info("boost::ptr_vector< Point >::iterator").pointerTypes("java.util.Iterator<Point>"))
                .put(new Info("boost::ptr_vector<SFCGAL::Point>::iterator").pointerTypes("java.util.Iterator<Point>"))
                .put(new Info("boost::ptr_vector<SFCGAL::Point>::const_iterator").pointerTypes("java.util.Iterator<Point>"))
                .put(new Info("boost::ptr_vector<Point>::const_iterator").pointerTypes("java.util.Iterator<Point>"))

                .put(new Info("boost::ptr_vector<SFCGAL::PolyhedralSurface>::iterator").pointerTypes("java.util.Iterator<PolyhedralSurface>"))
                .put(new Info("boost::ptr_vector<PolyhedralSurface>::iterator").pointerTypes("java.util.Iterator<PolyhedralSurface>"))
                .put(new Info("boost::ptr_vector<Geometry>::iterator").pointerTypes("java.util.Iterator<Geometry>"))

                .put(new Info("boost::ptr_vector<SFCGAL::Triangle>::iterator").pointerTypes("java.util.Iterator<Triangle>"))
                .put(new Info("boost::ptr_vector<Triangle>::iterator").pointerTypes("java.util.Iterator<Triangle>"))

                .put(new Info("boost::ptr_vector<SFCGAL::Polygon>::iterator").pointerTypes("java.util.Iterator<Polygon>"))
                .put(new Info("boost::ptr_vector<Polygon>::iterator").pointerTypes("java.util.Iterator<Polygon>"))

                .put(new Info("boost::ptr_vector<SFCGAL::LineString>::iterator").pointerTypes("java.util.Iterator<LineString>"))
                .put(new Info("boost::ptr_vector<LineString>::iterator").pointerTypes("java.util.Iterator<LineString>"))




                .put(new Info("detail::MarkedPolyhedron").pointerTypes("CGAL.Polyhedron_3.Polyhedron_3"))
                .put(new Info("CGAL::Polygon_2<SFCGAL::Kernel>").pointerTypes("CGAL.Kernel.Polygon_2"))
                .put(new Info("CGAL::Polygon_with_holes_2<SFCGAL::Kernel>").pointerTypes("CGAL.Kernel.Polygon_2"))
                .put(new Info("SFCGAL::GeometryType").pointerTypes("int"))
                .put(new Info("Kernel::Point_3").pointerTypes("CGAL.Kernel.Point_3"))
                .put(new Info("Kernel::Point_2").pointerTypes("CGAL.Kernel.Point_2"))
                .put(new Info("Kernel::Vector_2").pointerTypes("CGAL.Kernel.Vector_2"))
                .put(new Info("Kernel::Vector_3").pointerTypes("CGAL.Kernel.Vector_3"))
                .put(new Info("CGAL::Bbox_2").pointerTypes("CGAL.Kernel.Bbox_2"))
                .put(new Info("CGAL::Bbox_3").pointerTypes("CGAL.Kernel.Bbox_3"))
                .put(new Info("Kernel::Triangle_2").pointerTypes("CGAL.Kernel.Triangle_2"))
                .put(new Info("Kernel::Triangle_3").pointerTypes("CGAL.Kernel.Triangle_3"))





        ;
    }

}
