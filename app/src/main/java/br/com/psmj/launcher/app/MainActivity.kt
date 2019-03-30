package br.com.psmj.launcher.app

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    companion object {
        private const val C4M_PKG_NAME = "br.com.mobiltec.c4m.android.agent"
        private const val ANDROID_DPC_PKG_NAME = "com.google.android.apps.work.clouddpc"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onOpenSettingsButtonClick(view: View) {
        startActivity(Intent(Settings.ACTION_SETTINGS))
    }

    fun onC4MOpenButtonClick(view: View) {
        if (this.packageManager.isPackageInstalled(C4M_PKG_NAME))
            startActivity(this.packageManager.getLaunchIntentForPackage(C4M_PKG_NAME))
        else
            Toast.makeText(this, "C4M Agent is not installed.", Toast.LENGTH_SHORT).show()
    }

    fun onAndroidPolicyButtonClick(view: View) {
        if (this.packageManager.isPackageInstalled(ANDROID_DPC_PKG_NAME))
            startActivity(this.packageManager.getLaunchIntentForPackage(ANDROID_DPC_PKG_NAME))
        else
            Toast.makeText(this, "Android Device Policy is not installed.", Toast.LENGTH_SHORT).show()
    }
}
