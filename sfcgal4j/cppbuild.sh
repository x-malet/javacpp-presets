#!/bin/bash
# This file is meant to be included by the parent cppbuild.sh script
if [[ -z "$PLATFORM" ]]; then
  pushd ..
  bash cppbuild.sh "$@" sfcgal4j
  popd
  exit
fi

CGAL_VERSION=5.2.1
SFCGAL_GIT=SFCGAL-master

download "https://gitlab.com/Oslandia/SFCGAL/-/archive/master/$SFCGAL_GIT.tar.gz" SFCGAL.tar.gz
download "https://github.com/CGAL/cgal/releases/download/v5.2.1/CGAL-$CGAL_VERSION.tar.xz" CGAL-$CGAL_VERSION.tar.xz

mkdir -p $PLATFORM
cd $PLATFORM
INSTALL_PATH=$(pwd)

# Déclaration de l'ensemble des variables pour
CGAL_INSTALL_PATH=$INSTALL_PATH/CGAL
SFCGAL_INSTALL_PATH=$INSTALL_PATH/SFCGAL
CGAL_DIR=$INSTALL_PATH/lib/cmake/CGAL
CGAL_INCLUDE_DIRS=$INSTALL_PATH/include/CGAL
CGAL_LIBRARY_DIRS=$INSTALL_PATH/lib/
CGAL_SWING_BINDING_FOLDER=$INSTALL_PATH/cgal-swig-bindings
CGAL_SWIG_JAVA=$INSTALL_PATH/

echo "Decompressing archives..."
mkdir -p $CGAL_INSTALL_PATH
mkdir -p $SFCGAL_INSTALL_PATH
tar --totals -xf ../SFCGAL.tar.gz -C $SFCGAL_INSTALL_PATH --strip-components 1
tar --totals -xf ../CGAL-$CGAL_VERSION.tar.xz -C $CGAL_INSTALL_PATH --strip-components 1

function install_cgal() {
  echo "Installing CGAL to $INSTALL_PATH"
  cd $CGAL_INSTALL_PATH
  rm -rf build
  mkdir -p build
  cd build
  cmake .. -DCMAKE_INSTALL_PREFIX=$INSTALL_PATH -DCMAKE_BUILD_TYPE=Release -DCGAL_HEADER_ONLY=OFF
  make -j $MAKEJ
  make install
  echo "Installing CGAL done"
}

function install_cgal_swig_bindings() {
  echo "Install CGAL Swig bindings"

  cd $INSTALL_PATH
  if ! [ -d $CGAL_SWING_BINDING_FOLDER ]; then
    git clone https://github.com/cgal/cgal-swig-bindings || echo
  fi
  cd $CGAL_SWING_BINDING_FOLDER

  mkdir -p build/CGAL-5.0_release -p
  cd build/CGAL-5.0_release
  export CGAL_DIR="$INSTALL_PATH/lib/cmake/CGAL"
#    cmake -DCGAL_DIR=$CGAL_LIBRARY_DIRS -DBUILD_JAVA=ON -DBUILD_PYTHON=OFF -DJAVA_OUTDIR_PREFIX=$CGAL_SWIG_JAVA -DCMAKE_BUILD_TYPE=Release ../..
#    make -j $MAKEJ
  cd $INSTALL_PATH/../../
  mkdir -p src/gen/java/org/bytedeco
  cp -r $CGAL_SWIG_JAVA/CGAL src/gen/java/org/bytedeco

}

function install_sfcgal() {

  echo "======================================================="
  echo "Installing SFCGAL to $INSTALL_PATH"
  cd $SFCGAL_INSTALL_PATH
  cmake . -DCMAKE_INSTALL_PREFIX=$INSTALL_PATH -DCMAKE_BUILD_TYPE=Release -DCGAL_DIR=$CGAL_DIR
  make -j $MAKEJ
  make install
}

function install_for_linux() {
#  install_cgal
  install_cgal_swig_bindings
#  install_sfcgal

}

case $PLATFORM in
linux-x86)
  install_for_linux
  ;;
linux-x86_64)
  install_for_linux
  ;;
*)
  echo "Error: Platform \"$PLATFORM\" is not supported"
  ;;
esac

cd ../
