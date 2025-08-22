require recipes-st/images/st-image-userfs.bb

# Define a proper userfs for myir-image-full
STM32MP_USERFS_IMAGE = "myir-image-full-userfs"

# temporary fix
IMAGE_PARTITION_MOUNTPOINT = "/usr/local"

PACKAGE_INSTALL += "\
    packagegroup-x-linux-qt \
"
