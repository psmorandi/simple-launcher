package br.com.psmj.launcher.app

import android.content.pm.PackageManager

fun PackageManager.isPackageInstalled(packageName: String): Boolean {
    return try {
        this.getPackageInfo(packageName, 0)
        true
    } catch (e: PackageManager.NameNotFoundException) {
        false
    }
}