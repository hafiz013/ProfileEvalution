package com.user.profileevalution.utils

import java.text.SimpleDateFormat

class Function {
    companion object{
        fun getTime(date: String): String {
            var inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            var outputFormat = SimpleDateFormat("yyyy-MM-dd")
            var date = inputFormat.parse(date)
            return outputFormat.format(date)
        }
    }
}