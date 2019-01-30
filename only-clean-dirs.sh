#!/bin/bash


# comment.


um2=
localm2=
libtarget=
libdir=







um2_v_my_timbre_lib="$HOME/.m2/repository/my-timbre-lib/*"
um2_v_my_ctlogging_lib="$HOME/.m2/repository/my-ctlogging-lib/*"

localm2_v_my_timbre_lib="./my-timbre-app/local-m2/my-timbre-lib/*"
localm2_v_my_ctlogging_lib="./my-timbre-app/local-m2/my-ctlogging-lib/*"

libtarget_v_my_timbre_lib="./my-ex-libs/my-timbre-lib/target/*"
libtarget_v_my_ctlogging_lib="./my-ex-libs/my-ctlogging-lib/target/*"

libdir_v_my_timbre_lib="./my-ex-libs/my-timbre-lib/"
libdir_v_my_ctlogging_lib="./my-ex-libs/my-ctlogging-lib/"



apptarget="./my-timbre-app/target/*"



usage()
{
    echo "usage: clean-dirs-and-lein-install [[-s sourcerepo ] | [-h]]"
}



while [ "$1" != "" ]; do
    case $1 in
        -s | --source )           shift
                                 sourcerepo=$1
                                 ;;   
        -h | --help )           usage
                                exit
                                 ;;
        * )                     usage
                                exit 1
    esac
    shift
done



if [ $sourcerepo = "my-timbre-lib" ]; then
    echo "sourcerepo is set to my-timbre-lib"
    um2=$um2_v_my_timbre_lib
    localm2=$localm2_v_timbre_lib
    libtarget=$libtarget_v_my_timbre_lib
    libdir=$libdir_v_my_timbre_lib

elif [ $sourcerepo = "my-ctlogging-lib" ]; then
    echo "sourcerepo is set to my-ctlogging-lib"
    um2=$um2_v_my_ctlogging_lib
    localm2=$localm2_v_my_ctlogging_lib
    libtarget=$libtarget_v_my_ctlogging_lib
    libdir=$libdir_v_my_ctlogging_lib


else
    echo "No valid repo option given. The options are: '-s my-timbre-lib' , '-s my-ctlogging-lib'. "
    usage
    exit 1
fi



echo cleaning up dirs.
echo removing um2_v
rm -rf $um2 

echo removing localm2_v
rm -rf $localm2

echo removing btb_target
rm -rf $libtarget

echo removing cs_target
rm -rf $apptarget


echo done!
