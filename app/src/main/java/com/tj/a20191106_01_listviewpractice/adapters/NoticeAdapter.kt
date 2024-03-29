package com.tj.a20191106_01_listviewpractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.tj.a20191106_01_listviewpractice.R
import com.tj.a20191106_01_listviewpractice.datas.NoticeData

class NoticeAdapter(context: Context, res:Int, list:ArrayList<NoticeData>)
    : ArrayAdapter<NoticeData> (context, R.layout.notice_list_item, list) {

    var mContext = context
    var mList = list
    var inf = LayoutInflater.from(context)

    constructor(context: Context, list: ArrayList<NoticeData>) : this (context, R.layout.notice_list_item, list)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.notice_list_item, null)
        }
//  tempRow가 null인 경우를 대비 했으니, row에 tempRow는 절대 null이 아니라고 하면서 대입
        var row = tempRow!!

        var data = mList.get(position)

        var titleTxt = row.findViewById<TextView>(R.id.titleTxt)
        var dateTxt = row.findViewById<TextView>(R.id.dateTxt)
        var contentTxt = row.findViewById<TextView>(R.id.contentTxt)

        titleTxt.text = data.title
        dateTxt.text = data.writeData
        contentTxt.text = data.content

        return row
    }

}