package com.example.myapplication.model

import com.example.myapplication.R
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Calendar

class DataFactory {
    companion object {
        fun getOffers(): List<Offer> {
            val response= ArrayList<Offer>()

            response.add(Offer(1, "Barcelona, 3 nights", "description for Barecelona", 540, "EUR", R.drawable.offer_1))
            response.add(Offer(2, "Thailand, 7 nights", "description for Thailand", 1500, "EUR", R.drawable.offer_2))
            response.add(Offer(3, "Bahamas, 5 nights", "description for Bahamas", 1250, "EUR", R.drawable.offer_3))

            return response
        }

        fun getChatMessages(number: Int): ArrayList<ChatMessage>{
            val response = ArrayList<ChatMessage>()
            val calendar = Calendar.getInstance()

            val current = LocalDateTime.of(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND)
            )

            for(i in 1 .. number ) {
                response.add(ChatMessage(
                    1, "Computer", "Chat message #${i}",
                    //"2024-12-03 14:52"))
                    current.toString()))
            }

            return response
        }
    }
}