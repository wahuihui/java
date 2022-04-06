//存储所有的省份
let provinces

//存储所有的城市
let cities

//存储所有的县区
let counties

/**
 * 初始化省市区数据 数组
 */
function initData(){
    //创建北京市对象
    let beijingProvince = {}
    //北京市对象有provinceId和provinceName属性，分别表示省份id和省份名称
    beijingProvince.provinceId = 1
    beijingProvince.provinceName = "北京市"
    console.log(beijingProvince)

    let beijingCity = {}
    beijingCity.provinceId = 1
    beijingCity.cityId = 1
    beijingCity.cityName = "北京市"
    console.log(beijingCity)

    let chaoYang = {}
    chaoYang.provinceId = 1
    chaoYang.cityId = 1
    chaoYang.countyId = 1
    chaoYang.countyName = "朝阳区"
    console.log(chaoYang)

    let dongCheng = {}
    dongCheng.provinceId = 1
    dongCheng.cityId = 1
    dongCheng.countyId = 2
    dongCheng.countyName = "东城区"
    console.log(dongCheng)

    let haiDian = {}
    haiDian.provinceId = 1
    haiDian.cityId = 1
    haiDian.countyId = 3
    haiDian.countyName = "海淀区"
    console.log(haiDian)

    //创建上海市对象
    let shanghaiProvince = {}
    shanghaiProvince.provinceId = 2
    shanghaiProvince.provinceName = "上海市"
    console.log(shanghaiProvince)

    let shanghaiCity = {}
    shanghaiCity.provinceId = 2
    shanghaiCity.cityId = 1
    shanghaiCity.cityName = "上海市"
    console.log(shanghaiCity)

    let huangPu = {}
    huangPu.provinceId = 2
    huangPu.cityId = 1
    huangPu.countyId = 1
    huangPu.countyName = "黄浦区"
    console.log(huangPu)

    let puDong = {}
    puDong.provinceId = 2
    puDong.cityId = 1
    puDong.countyId = 2
    puDong.countyName = "浦东新区"
    console.log(puDong)

    let jingAn = {}
    jingAn.provinceId = 2
    jingAn.cityId = 1
    jingAn.countyId = 3
    jingAn.countyName = "静安区"
    console.log(jingAn)

    //创建广东省对象
    let guangdongProvince = {}
    guangdongProvince.provinceId = 3
    guangdongProvince.provinceName = "广东省"
    console.log(guangdongProvince)

    let guangzhouCity = {}
    guangzhouCity.provinceId = 3
    guangzhouCity.cityId = 1
    guangzhouCity.cityName = "广州市"
    console.log(guangzhouCity)

    let shenzhenCity = {}
    shenzhenCity.provinceId = 3
    shenzhenCity.cityId = 2
    shenzhenCity.cityName = "深圳市"
    console.log(shenzhenCity)

    let haiZhu = {}
    haiZhu.provinceId = 3
    haiZhu.cityId = 1
    haiZhu.countyId = 1
    haiZhu.countyName = "海珠区"
    console.log(haiZhu)

    let baiYun = {}
    baiYun.provinceId = 3
    baiYun.cityId = 1
    baiYun.countyId = 2
    baiYun.countyName = "白云区"
    console.log(baiYun)

    let luoHu = {}
    luoHu.provinceId = 3
    luoHu.cityId = 2
    luoHu.countyId = 1
    luoHu.countyName = "罗湖区"
    console.log(luoHu)

    let nanShan = {}
    nanShan.provinceId = 3
    nanShan.cityId = 2
    nanShan.countyId = 2
    nanShan.countyName = "南山区"
    console.log(nanShan)

    //创建江苏省对象
    let jiangsuProvince = {}
    jiangsuProvince.provinceId = 4
    jiangsuProvince.provinceName = "江苏省"
    console.log(jiangsuProvince)

    let nanjingCity = {}
    nanjingCity.provinceId = 4
    nanjingCity.cityId = 1
    nanjingCity.cityName = "南京市"
    console.log(nanjingCity)

    let xuanWu = {}
    xuanWu.provinceId = 4
    xuanWu.cityId = 1
    xuanWu.countyId = 1
    xuanWu.countyName = "玄武区"
    console.log(xuanWu)

    //创建浙江省对象
    let zhejiangProvince = {}
    zhejiangProvince.provinceId = 5
    zhejiangProvince.provinceName = "浙江省"
    console.log(zhejiangProvince)

    let hangzhouCity = {}
    hangzhouCity.provinceId = 5
    hangzhouCity.cityId = 1
    hangzhouCity.cityName = "杭州市"
    console.log(hangzhouCity)

    let xiaLa = {}
    xiaLa.provinceId = 5
    xiaLa.cityId = 1
    xiaLa.countyId = 1
    xiaLa.countyName = "西湖区"
    console.log(xiaLa)



    provinces = [beijingProvince,shanghaiProvince,guangdongProvince,jiangsuProvince,zhejiangProvince]

    cities = [beijingCity,shanghaiCity,guangzhouCity,shenzhenCity,nanjingCity,hangzhouCity]

    counties = [
        dongCheng,
        chaoYang,
        haiDian,
        huangPu,
        puDong,
        jingAn,
        baiYun,
        haiZhu,
        luoHu,
        nanShan,
        xuanWu,
        xiaLa
    ]
}

/**
 * 页面加载完成以后，调用initData()方法
 */
window.onload=function (){
    initData()

    //绑定省份
    for (let i = 0; i < provinces.length; i++) {
        //创建option标签
        let optionElement = document.createElement("option");
        optionElement.setAttribute("value",provinces[i].provinceId)
        optionElement.innerText=provinces[i].provinceName
        //通过id找到省的下拉框
        let provinceSelectElement = document.getElementById("provinceSelect");
        provinceSelectElement.append(optionElement)
    }
}

/**
 * 根据省分获取省份下的城市
 */
function getCities(provinceId){
    console.log("用户选择的省份的id是："+provinceId)

    let citySelectElement = document.getElementById("citySelect");

    //给id为citySelect下拉框添加option之前要清空数据
    citySelectElement.innerHTML = "<option value=\"0\" selected>--请选择城市--</option>"
    //遍历城市
    for (let i = 0; i < cities.length; i++) {
        if (provinceId==cities[i].provinceId){
            console.log("城市的id："+cities[i].cityId)
            console.log("城市的name："+cities[i].cityName)

            //创建option标签
            let optionElement = document.createElement("option");
            optionElement.setAttribute("value",cities[i].cityId)
            optionElement.innerText=cities[i].cityName
            citySelectElement.append(optionElement)
        }
    }
}

/**
 * 根据城市id获取县区
 */
function getCounties(cityId){
    console.log("用户选择的城市id是："+cityId)

    let provinceSelectElement = document.getElementById("provinceSelect");
    let optionSelectedIndex = provinceSelectElement.selectedIndex;
    let provinceId = provinceSelectElement.options[optionSelectedIndex].value;
    console.log("选择的省份是："+provinceSelectElement.options[optionSelectedIndex].innerText)
    let countySelectElement = document.getElementById("countySelect");
    //给id为countrySelect下拉框添加option之前先要清空数据
    countySelectElement.innerHTML = "<option value=\"0\" selected>--请选择县/区--</option>"
    for (let i = 0; i < counties.length; i++) {
        if (provinceId==counties[i].provinceId && cityId==counties[i].cityId){
            let optionElement = document.createElement("option");
            optionElement.setAttribute("value",counties[i].countyId)
            optionElement.innerText = counties[i].countyName
            countySelectElement.append(optionElement)
        }
    }
}
