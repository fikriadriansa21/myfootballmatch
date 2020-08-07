package com.krayz.myfootballmatch.ui.profile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

import com.krayz.myfootballmatch.R
import com.krayz.myfootballmatch.ui.login.google.LoginWithGoogleActivity
import com.krayz.myfootballmatch.ui.main.MainActivity
import com.krayz.myfootballmatch.utils.Utils
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Utils.makeSharedPreference(this.context as Activity)
        val textName = Utils.getSharedPrefereces(Utils.NAMA)
        tv_name_user.text = textName

        val textUsername = Utils.getSharedPrefereces(Utils.USERNAME)
        tv_username.text = textUsername

        val textEmail = Utils.getSharedPrefereces(Utils.EMAIL)
        tv_email.text = textEmail

        val textLeagueFavorite = Utils.getSharedPrefereces(Utils.LEAGUE_NAME)
        tv_league_favorite.text = textLeagueFavorite

        val textTeamFavorite = Utils.getSharedPrefereces(Utils.TEAM_NAME)
        tv_team_favorite.text = textTeamFavorite

        val imageLeague = Utils.getSharedPrefereces(Utils.LOGO_LEAGUE)
        context?.let {
            Glide.with(it)
                .load(imageLeague)
                .override(124,124)
                .into(iv_league_fav)
        }

        val imageClub = Utils.getSharedPrefereces(Utils.LOGO_TEAM)
        context?.let {
            Glide.with(it)
                .load(imageClub)
                .override(124,124)
                .into(iv_team_fav)
        }

        btn_logout.setOnClickListener {
            val intent = Intent(this.context, MainActivity::class.java)
            startActivity(intent)
            activity?.finish()
            Utils.putSharedPreferences(Utils.EMAIL, "")
            Utils.putSharedPreferences(Utils.USERNAME, "")
            Utils.putSharedPreferences(Utils.PASSWORD, "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

}
