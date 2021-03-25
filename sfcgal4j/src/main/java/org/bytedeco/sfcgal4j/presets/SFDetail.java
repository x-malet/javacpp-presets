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
        target = "org.bytedeco.sfcgal4j.detail",
        global = "org.bytedeco.sfcgal4j.global.SFDetail",
        value = {
                @Platform(define = "SFCGAL_API", link = {"SFCGAL"},
                        resource = {"include"},
                        include = {
                                "SFCGAL/detail/ublas.h",
                                "SFCGAL/detail/generator/building.h",
                                "SFCGAL/detail/generator/disc.h",
                                "SFCGAL/detail/generator/sierpinski.h",
                                "SFCGAL/detail/generator/hoch.h",
                                "SFCGAL/detail/ForceValidityVisitor.h",
                                "SFCGAL/detail/GetPointsVisitor.h",
                                "SFCGAL/detail/TypeForDimension.h",
                                "SFCGAL/detail/Interval.h",
                                "SFCGAL/detail/GeometrySet.h",
                                "SFCGAL/detail/algorithm/coversPoints.h",
                                "SFCGAL/detail/triangulate/ConstraintDelaunayTriangulation.h",
                                "SFCGAL/detail/triangulate/markDomains.h",
                                "SFCGAL/detail/triangulate/triangulateInGeometrySet.h",
                                "SFCGAL/detail/TestGeometry.h",
                                "SFCGAL/detail/EnvelopeVisitor.h",
                                "SFCGAL/detail/polygonSetToMultiPolygon.h",
                                "SFCGAL/detail/ComplexComparator.h",
                                "SFCGAL/detail/Point_inside_polyhedron.h",
                                "SFCGAL/detail/io/OsgFactory.h",
                                "SFCGAL/detail/io/WktWriter.h",
                                "SFCGAL/detail/io/WktReader.h",
                                "SFCGAL/detail/io/Serialization.h",
                                "SFCGAL/detail/tools/CharArrayBuffer.h",
                                "SFCGAL/detail/tools/Log.h",
                                "SFCGAL/detail/tools/InputStreamReader.h",
                                "SFCGAL/detail/tools/Registry.h",
                                "SFCGAL/detail/graph/algorithm/isHalfEdge.h",
                                "SFCGAL/detail/graph/algorithm/orientation.h",
                                "SFCGAL/detail/graph/Vertex.h",
                                "SFCGAL/detail/graph/GeometryGraph.h",
                                "SFCGAL/detail/graph/GeometryGraphBuilder.h",
                                "SFCGAL/detail/graph/Edge.h",
                                "SFCGAL/detail/transform/ForceZOrderPoints.h",
                                "SFCGAL/detail/transform/AffineTransform3.h",
                                "SFCGAL/detail/transform/AffineTransform2.h",
                                "SFCGAL/detail/transform/Force2D.h",
                                "SFCGAL/detail/transform/RoundTransform.h",
                                "SFCGAL/detail/transform/ForceOrderPoints.h",
                                "SFCGAL/detail/transform/ForceZ.h",
                        }),
                @Platform(
                        value = {"linux"},
                        link = {"SFCGAL"}
                )})

public class SFDetail implements InfoMapper {
    static {
        Loader.checkVersion("org.bytedeco", "sfcgal4j");
    }

    public void map(InfoMap infoMap) {
        infoMap.put(new Info("SFCGAL_API").cppTypes().annotations());

    }
}
