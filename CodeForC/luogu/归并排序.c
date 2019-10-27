#include<stdio.h>
#include<stdlib.h>
void mergesort(int low, int high){               //归并排序主函数

};
/*
function mergeSort(arr) {  //采用自上而下的递归方法
    var len = arr.length; //获取传入数组的长度
    if(len < 2) {   //如果为单个元素则直接返回
        return arr;
    }
    var middle = Math.floor(len / 2),//取中点
        left = arr.slice(0, middle), //取左边区间
        right = arr.slice(middle);   //取右边区间
    return merge(mergeSort(left), mergeSort(right));//调用归并函数
}

function merge(left, right)//传入两个区间
{
    var result = [];//新建变量用于保存结果
    console.time('归并排序耗时');
    while (left.length && right.length) { //当左区间右区间存在时
        if (left[0] <= right[0]) {  //将区间中较小的一位从区间数组中放到结果数组中.
            result.push(left.shift());
        } else {
            result.push(right.shift());
        }
    }
    //下面两个while是为了解决遗留元素问题
    while (left.length) 
        result.push(left.shift());

    while (right.length)
        result.push(right.shift());
    return result;//返回结果
}
*/
int main(int argc,char* args[])
{

    return 0;
}
