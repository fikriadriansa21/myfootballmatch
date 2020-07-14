package com.example.myfootballmatch.register.pickleagueregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfootballmatch.R
import com.example.myfootballmatch.country.CountryViewModel
import com.example.myfootballmatch.country.adapter.CountryAdapter
import com.example.myfootballmatch.country.model.Country
import com.example.myfootballmatch.network.NetworkConfig
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_pick_league_register.*
import kotlinx.android.synthetic.main.item_country.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class PickLeagueRegisterActivity : AppCompatActivity(), CountryViewModel.CountriesCallBack {

    private lateinit var countryViewModel: CountryViewModel
    private lateinit var rvCountry: RecyclerView
    private lateinit var countryAdapter: CountryAdapter
    private lateinit var list: List<Country>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_league_register)





    }

    private fun showBottomSheetDialog() {
        val view = layoutInflater.inflate(R.layout.bottom_sheet_layout, null)
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(view)
        dialog.show()
    }

    override fun onSuccess(data: List<Country>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun generateData(dataList: List<Country>){
        rvCountry = findViewById(R.id.rv_league)
        rvCountry.setHasFixedSize(true)

        list = ArrayList()
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvCountry.layoutManager = layoutManager

        countryAdapter = CountryAdapter(list as ArrayList<Country>)
//        countryViewModel = ViewModelProviders.of(this).get(CountryViewModel::class.java)
//        ViewModelProvider.NewInstanceFactory()
        countryViewModel.getListCountries(this)

        rvCountry.adapter = countryAdapter

//        btn_select_country.setOnClickListener {
//            showBottomSheetDialog()
//        }
    }
}
