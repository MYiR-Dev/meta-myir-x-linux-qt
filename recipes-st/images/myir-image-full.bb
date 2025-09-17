require recipes-st/images/myir-image-weston.bb

inherit populate_sdk_qt6 features_check

# need to have wayland feature
REQUIRED_DISTRO_FEATURES = "wayland"

SUMMARY = "OpenSTLinux Qt Framework image based on weston image"

# Define a proper userfs for st-image-qt
STM32MP_USERFS_IMAGE = "myir-image-full-userfs"
BOOTDEVICE_LABELS = "emmc sdcard"

# Define ROOTFS_MAXSIZE to 3GB
IMAGE_ROOTFS_MAXSIZE = "3145728"

BOOTDEVICE_LABELS = "emmc sdcard"

# Define the size of userfs
STM32MP_USERFS_SIZE = "307200"
PARTITIONS_IMAGES[userfs]   = "${STM32MP_USERFS_IMAGE},${STM32MP_USERFS_LABEL},${STM32MP_USERFS_MOUNTPOINT},${STM32MP_USERFS_SIZE},FileSystem"

IMAGE_QT_PART = "   \
    packagegroup-x-linux-qt \
"

#
# INSTALL addons
#
CORE_IMAGE_EXTRA_INSTALL += " \
    ${IMAGE_QT_PART}          \
"

IMAGE_FEATURES += "dev-pkgs"
