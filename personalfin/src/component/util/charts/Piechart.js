import React, { Component } from "react";
import * as echarts from "echarts/core";
import ReactECharts from "echarts-for-react";

export default class Piechart extends Component {
  option = {
    color: [
      "black",
      "black",
      "black",
      "black",
      "black",
      "black",
      "black",
      "black",
    ],
    title: {},
    tooltip: {
      show: false,
    },
    series: [
      {
        type: "pie",
        label: {
          position: "outside",
          color: "white",
          fontSize: ".8rem",
        },
        labelLine: {
          show: true,
          lineStyle: {
            width: 1,
            color: "white",
          },
        },
        radius: ["40%", "70%"],
        data: [
          { value: 1048, name: "Apple" },
          { value: 735, name: "Amazon" },
          { value: 580, name: "Netflix" },
          { value: 484, name: "Bank of America" },
          { value: 300, name: "TCS" },
          { value: 1048, name: "Apple" },
          { value: 735, name: "Amazon" },
          { value: 580, name: "Netflix" },
          { value: 484, name: "Bank of America" },
          { value: 300, name: "TCS" },
          { value: 1048, name: "Apple" },
          { value: 735, name: "Amazon" },
          { value: 580, name: "Netflix" },
          { value: 484, name: "Bank of America" },
          { value: 300, name: "TCS" },
        ],
        emphasis: {},
        itemStyle: {
          borderColor: "white",
        },
      },
    ],
  };
  render() {
    return (
      <ReactECharts
        echarts={echarts}
        option={this.option}
        notMerge={true}
        lazyUpdate={true}
        theme={"theme_name"}
        style={{
          height: "100%",
          width: "100%",
        }}
      />
    );
  }
}
