SUMMARY = "Packagegroup for X-LINUX-QT embedded Linux image"
LICENSE = "MIT & Apache-2.0 & BSD-3-Clause"

LIC_FILES_CHKSUM  = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
LIC_FILES_CHKSUM += "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
LIC_FILES_CHKSUM += "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PV = "2.1.0"

inherit packagegroup features_check

# Requires Wayland to work
REQUIRED_DISTRO_FEATURES = "wayland"

ST_APPS ?= "packagegroup-x-linux-qt-apps"
ST_APPS:stm32mp13common = ""
ST_APPS:stm32mp21common = ""

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-myir-linux-qt        \
    packagegroup-myir-linux-qt-core   \
    packagegroup-myir-linux-qt-base   \
    packagegroup-myir-linux-qt-extra  \
    ${ST_APPS}                     \
    "

# Manage to provide all Qt Framework core packages with overall one
RDEPENDS:packagegroup-myir-linux-qt = "\
    packagegroup-myir-linux-qt-core   \
    packagegroup-myir-linux-qt-base   \
    packagegroup-myir-linux-qt-extra  \
    ${ST_APPS}                     \
    "

SUMMARY:packagegroup-myir-linux-qt-core = "X-LINUX-QT Core components"
RDEPENDS:packagegroup-myir-linux-qt-core = "\
    alsa-utils-amixer \
    binutils \
    binutils-symlinks \
    e2fsprogs-resize2fs \
    htop \
    i2c-tools \
    iproute2 \
    ldd \
    mtd-utils \
    openssh-sftp-server \
    parted \
    procps \
    rsync \
    tslib-calibrate \
    ${@bb.utils.contains("DISTRO_FEATURES", "systemd", "systemd-analyze", "", d)} \
    openstlinux-qt \
    "

SUMMARY:packagegroup-myir-linux-qt-base = "X-LINUX-QT Base components"
RDEPENDS:packagegroup-myir-linux-qt-base = "\
    qtbase                          \
    qtbase-plugins                  \
    qtbase-tools                    \
    qt5compat                       \
    qt5compat-plugins               \
    qt5compat-qmlplugins            \
    liberation-fonts                \
    \
    qtdeclarative                   \
    qtdeclarative-qmlplugins        \
    qtdeclarative-tools             \
    \
    qtmultimedia                    \
    qtmultimedia-plugins            \
    qtmultimedia-qmlplugins         \
    \
    qttools                         \
    \
    qtgraphs                        \
    qtgraphs-plugins                \
    qtgraphs-qmlplugins             \
    "

SUMMARY:packagegroup-myir-linux-qt-extra = "X-LINUX-QT Extra components"
RDEPENDS:packagegroup-myir-linux-qt-extra = "\
    \
    qtsvg                       \
    qtsvg-plugins               \
    qtsvg-qmlplugins            \
    \
    qtsensors                   \
    qtsensors-plugins           \
    qtserialport                \
    qtserialport-plugins        \
    qtcharts                    \
    qtcharts-plugins            \
    qtcharts-qmlplugins         \
    \
    qtimageformats              \
    qtimageformats-plugins      \
    qtimageformats-qmlplugins   \
    \
    qtquicktimeline             \
    qtquicktimeline-plugins     \
    qtquicktimeline-qmlplugins  \
    \
    qtvirtualkeyboard           \
    qtvirtualkeyboard-plugins   \
    qtvirtualkeyboard-qmlplugins \
    \
    qtremoteobjects             \
    qtremoteobjects-plugins     \
    qtquickdesigner-components  \
    "

SUMMARY:packagegroup-myir-linux-qt-apps = "X-LINUX-QT Applications"
RDEPENDS:packagegroup-myir-linux-qt-apps = "\
    ${@bb.utils.contains("DISTRO_FEATURES", "wayland", "stlauncher", "", d)} \
    "

ST_DEMOS = ""
ST_DEMOS:append:stm32mp2common = "\
    st-demo-medical             \
    st-demo-robotarm3d          \
    "

SUMMARY:packagegroup-myir-linux-qt-demos = "X-LINUX-QT Application Demos"
RDEPENDS:packagegroup-myir-linux-qt-demos = "${ST_DEMOS}"

SUMMARY:packagegroup-myir-linux-qt-examples = "X-LINUX-QT Application Examples"
RDEPENDS:packagegroup-myir-linux-qt-examples = "\
    qtbase-examples             \
    qtvirtualkeyboard-examples  \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtquick3d-examples', '', d)} \
    "
