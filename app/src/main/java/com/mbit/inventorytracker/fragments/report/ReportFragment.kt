package com.mbit.inventorytracker.fragments.report

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mbit.inventorytracker.R
import com.mbit.inventorytracker.fragments.abstraction.FragmentBase
import kotlinx.android.synthetic.main.fragment_report.*

class ReportFragment : FragmentBase(), IOnReselectListener {

    private val _pagerAdapter: ReportPagerAdapter by lazy { ReportPagerAdapter(childFragmentManager, activity) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_report, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view_pager.adapter = _pagerAdapter
    }

    override fun onReselect() {
        view_pager.setCurrentItem(0, true)
        (_pagerAdapter.getItem(view_pager.currentItem) as? IOnReselectListener)?.run { onReselect() }
    }
}