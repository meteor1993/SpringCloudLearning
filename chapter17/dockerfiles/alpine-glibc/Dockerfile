FROM alpine:3.10
MAINTAINER inwsy@hotmail.com
RUN apk add --no-cache ca-certificates curl openssl binutils xz tzdata \
    && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone \
    && GLIBC_VER="2.30-r0" \
    && ALPINE_GLIBC_REPO="https://github.com/sgerrand/alpine-pkg-glibc/releases/download" \
    && curl -Ls ${ALPINE_GLIBC_REPO}/${GLIBC_VER}/glibc-${GLIBC_VER}.apk > /opt/${GLIBC_VER}.apk \
    && apk add --allow-untrusted /opt/${GLIBC_VER}.apk \
    && curl -Ls https://www.archlinux.org/packages/core/x86_64/gcc-libs/download > /opt/gcc-libs.tar.xz \
    && mkdir /opt/gcc \
    && tar -xf /opt/gcc-libs.tar.xz -C /opt/gcc \
    && mv /opt/gcc/usr/lib/libgcc* /opt/gcc/usr/lib/libstdc++* /usr/glibc-compat/lib \
    && strip /usr/glibc-compat/lib/libgcc_s.so.* /usr/glibc-compat/lib/libstdc++.so* \
    && curl -Ls https://www.archlinux.org/packages/core/x86_64/zlib/download > /opt/libz.tar.xz \
    && mkdir /opt/libz \
    && tar -xf /opt/libz.tar.xz -C /opt/libz \
    && mv /opt/libz/usr/lib/libz.so* /usr/glibc-compat/lib \
    && apk del binutils \
    && rm -rf /opt/${GLIBC_VER}.apk /opt/gcc /opt/gcc-libs.tar.xz /opt/libz /opt/libz.tar.xz /var/cache/apk/*