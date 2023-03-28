package com.example.nycschool.models

/**
 * kotlin data classes can contain only 127 args. so if the data class contains more
 * than 127 arguments to it then the data will not load. So always make sure to check
 * how big your data is in the api that we are calling
 *
 * Error it shows if data class has more than 127 arguments: Unable to invoke no-args constructor for class ABC.
 * Registering an InstanceCreator with Gson for this type may fix this problem
 */

data class SchoolItem(
//    val academicopportunities1: String,
//    val academicopportunities2: String,
//    val academicopportunities3: String,
//    val academicopportunities4: String,
//    val academicopportunities5: String,
//    val addtl_info1: String,
//    val attendance_rate: String,
//    val auditioninformation1: String,
//    val auditioninformation2: String,
//    val auditioninformation3: String,
//    val auditioninformation4: String,
//    val auditioninformation5: String,
//    val auditioninformation6: String,
//    val auditioninformation7: String,
//    val bbl: String,
//    val bin: String,
//    val boro: String,
//    val borough: String,
//    val boys: String,
//    val building_code: String,
//    val bus: String,
//    val campus_name: String,
//    val census_tract: String,
//    val city: String,
//    val code1: String,
//    val code10: String,
//    val code2: String,
//    val code3: String,
//    val code4: String,
//    val code5: String,
//    val code6: String,
//    val code7: String,
//    val code8: String,
//    val code9: String,
//    val college_career_rate: String,
//    val common_audition1: String,
//    val common_audition2: String,
//    val common_audition3: String,
//    val common_audition4: String,
//    val common_audition5: String,
//    val common_audition6: String,
//    val common_audition7: String,
//    val community_board: String,
//    val council_district: String,
    val dbn: String,
//    val pct_stu_enough_variety: String,
//    val pct_stu_safe: String,
//    val phone_number: String,
//    val school_10th_seats: String,
//    val school_accessibility_description: String,
//    val school_email: String,
    val school_name: String
//    val school_sports: String,
//    val total_students: String,
//    val transfer: String,
//    val website: String,
//    val zip: String
)

