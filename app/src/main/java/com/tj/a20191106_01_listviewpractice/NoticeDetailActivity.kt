package com.tj.a20191106_01_listviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tj.a20191106_01_listviewpractice.datas.NoticeData
import kotlinx.android.synthetic.main.activity_notice_detail.*

class NoticeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice_detail)

        var notice:NoticeData = intent.getSerializableExtra("notice") as NoticeData

        detailTitleTxt.text = notice.title
        detailContentTxt.text = notice.content

    }
}
