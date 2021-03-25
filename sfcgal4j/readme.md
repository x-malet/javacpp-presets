to install just run from the parent directory

`sudo mvn install --projects .,sfcgal4j`

pour une compilation controlée:
`sudo rm -rf sfcgal4j/src/gen && sudo mvn package --projects .,sfcgal4j -Djavacpp.cppbuild.skip=true -Djavacpp.compiler.skip=false -Djavacpp.parser.skip=false`