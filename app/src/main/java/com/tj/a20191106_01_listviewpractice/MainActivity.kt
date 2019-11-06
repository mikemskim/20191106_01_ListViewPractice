package com.tj.a20191106_01_listviewpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tj.a20191106_01_listviewpractice.adapters.NoticeAdapter
import com.tj.a20191106_01_listviewpractice.datas.NoticeData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var noticeList = ArrayList<NoticeData>()
    var noticeAdapter:NoticeAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setValues()

        setupEvent()

    }

    fun setValues() {
        addNotice()

        noticeAdapter = NoticeAdapter(this, noticeList)

        noticeListView.adapter = noticeAdapter

    }

    fun setupEvent() {
        addNoticeBtn.setOnClickListener {
            noticeList.add(NoticeData("새 공지사항", "내용도 적어봅니다.", "2019-11-06"))
            // 데이터 변경 사항 -> 리스트 뷰에 반영
            noticeAdapter?.notifyDataSetChanged()
            // 10칸 => 9번, 150칸 => 139
            noticeListView.smoothScrollToPosition(noticeList.size-1)
        }

        noticeListView.setOnItemClickListener { parent, view, position, id ->

            //            Toast.makeText(this, "${position} 번째 줄을 클릭했습니다.", Toast.LENGTH_SHORT).show()

            var noticeData = noticeList.get(position)

            var intent = Intent(this, NoticeDetailActivity::class.java)

            intent.putExtra("notice", noticeData)

            startActivity(intent)
        }

        noticeListView.setOnItemLongClickListener { parent, view, position, id ->
            Toast.makeText(this, "${position} 번째 줄을 길게 클릭했습니다.", Toast.LENGTH_SHORT).show()
            return@setOnItemLongClickListener true
        }
    }

    fun addNotice() {
        noticeList.add(NoticeData("1번 공지", "1번 내용입니다.", "2019-01-01"))
        noticeList.add(NoticeData("2번 공지", "2번 내용입니다.", "2019-02-01"))
        noticeList.add(NoticeData("3번 공지", "3번 내용입니다.", "2019-03-01"))
        noticeList.add(NoticeData("4번 공지", "4번 내용입니다.", "2019-04-01"))
        noticeList.add(NoticeData("5번 공지", "5번 내용입니다.", "2019-05-01"))
        noticeList.add(NoticeData("6번 공지", "6번 내용입니다.", "2019-06-01"))
        noticeList.add(NoticeData("7번 공지", "7번 내용입니다.", "2019-07-01"))
        noticeList.add(NoticeData("8번 공지", "8번 내용입니다.", "2019-08-01"))
        noticeList.add(NoticeData("9번 공지", "9번 내용입니다.", "2019-09-01"))
        noticeList.add(NoticeData("10번 공지", "10번 내용입니다.", "2019-10-01"))
        noticeList.add(NoticeData("11번 공지", "11번 내용입니다.", "2019-11-01"))
        noticeList.add(NoticeData("12번 공지", "12번 내용입니다.", "2019-11-06"))
    }
}
