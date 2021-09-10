import axios from "axios"
import { useEffect } from "react"
import { useState } from "react"
import Chart from "react-apexcharts"
import { SaleSum } from "types/sale"
import { BASE_URL } from "utils/requests"

type ChartData = {
    labels: string[],
    series: number[]
}

const DonutChart = () => {

    const [charData, setChartData] = useState<ChartData>({ labels: [], series: [] })
    useEffect(() => {
        axios.get(`${BASE_URL}/sales/amount-by-seller`)
            .then(res => {
                const data = res.data as SaleSum[]
                const myLabels = data.map(x => x.sellerName)
                const mySeries = data.map(x => x.sum);
                setChartData({
                    labels: myLabels,
                    series: mySeries
                })
            })
    }, [])

    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart
            options={{ ...options, labels: charData.labels }}
            series={charData.series}
            type="donut"
            height="240"
        />
    )
}

export default DonutChart