package com.pans.common.model

/**
 * Create by panchenhuan on 2020/4/26
 * walkwindc8@foxmail.com
 * Description:
 */
class SystemParamsBean {
    var Android: Map<String, String>? = null
    var hasndlingFee: Map<String, String>? = null
    var publicSystem: Map<String, String>? = null
    var zero: Map<String, String>? = null

    /**
     * miningMachineSorting    矿机列表排序
     * gemRanking 创业板排序
     * motherboardSort    主板排序
     * currencySort   币种排序
     */
    var miningMachineSorting: Map<String, String>? = null
    var gemRanking: Map<String, String>? = null
    var motherboardSort: Map<String, String>? = null
    var currencySort: Map<String, String>? = null

}