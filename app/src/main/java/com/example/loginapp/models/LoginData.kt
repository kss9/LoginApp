package com.example.loginapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class LoginData(

    var dealer_code: String,
    var position_id: String,
    var x_division_city: String,
    var position_name: String,
    var emp_row_id: String,
    var lob: String,
    var primary_postnid: String,
    var primary_emp: String,
    var area: String,
    var user_state: String,
    var organization_name: String,
    var lob_x_bu_unit_s: String,
    var _version_: String,
    var division_id: String,
    var postn_type_cd: String,
    var organization_id: String,
    var dsm_name: String,
    var lob_x_service_tax_flg_s: String,
    var region: String,
    var lob_row_id_s: String,
    var postn_pr_emp_cell_ph_num_s: String,
    var lob_name_s: String,
    var user_login_s: String





) : Parcelable