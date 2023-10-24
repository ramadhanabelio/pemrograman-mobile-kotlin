package herianto.ac.id.polbeng.onlineservice.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import herianto.ac.id.polbeng.onlineservice.R
import herianto.ac.id.polbeng.onlineservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_user_services,
                R.id.nav_user_profile, R.id.nav_logout
            ), drawerLayout
        )
        setupActionBarWithNavController(navController,
            appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.menu.findItem(R.id.nav_logout).setOnMenuItemClickListener()
        { menuItem ->
            drawerLayout.closeDrawers()
            logoutDialog()
            true
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController =
            findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) ||
                super.onSupportNavigateUp()
    }
    private fun logoutDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Keluar Akun")
        builder.setMessage("Apakah anda yakin keluar dari akun saat ini?")
        builder.setIcon(R.drawable.ic_baseline_exit_to_app_24)
        builder.setPositiveButton("Ya") { dialog, _ ->
            Snackbar.make(binding.root, "Anda mengklik Ya!",
                Snackbar.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        builder.setNegativeButton("Tidak"){ dialog, _ ->
            Snackbar.make(binding.root, "Anda mengklik Tidak!",
                Snackbar.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}