//Author: chenguofeng08qh@gmail.com

#include <iostream>
using namespace std;

template <class T>
int getArrayLen(T & Array)
{
	return (sizeof(Array))/(sizeof(Array[0]));
}

int partition (int v[], int w[], int begin, int end)
{
	double m = v[end-1]/w[end-1];
	int p = begin;
	for (int i =begin; i<end-1; i++)
	{
		double tmp = v[i]/w[i];
		if(tmp>=m){ 
			int tmpv = v[i];
			v[i] = v[p];
			v[p] = tmpv;
			int tmpw = w[i];
			w[i] = w[p];
			w[p] = tmpw; 
			p++;
		    }
	}
	int tmpv = v[end-1];
	v[end-1] = v[p];
	v[p] = tmpv;
	int tmpw = w[end-1];
	w[end-1] = w[p];
	w[p] = tmpw;
	return p;
}

double fractionalpackage (int v[], int w[], int weight, int start, int end, int result[])
{
	if(start >= end) return 0;
	int p = partition (v, w, start, end);
	int sum =0;
	double value = 0;
	for (int i =start; i<=p-1;i++)
	{
		sum += w[i];
	}
	if (sum > weight){
       return fractionalpackage (v, w,weight, start, p, result);
	} 
	else if(sum + w[p] >= weight)
	{
	 for (int i =start; i<=p-1;i++)
	{
		result[i] = w[i];
		value += v[i];
	}
	result[p] = weight - sum;
	value += v[p]*(weight - sum)/w[p];  
	return value;
	}
	else{
	for (int i =start; i<=p;i++)
	{
		result[i] = w[i];
		value += v[i];
	}
	return value + fractionalpackage (v, w,weight-sum-w[p], p+1, end, result);
	}
	
}


void main(){
	while(1)
	{   int weight,len;
		cout<<"请输入背包容量：";
		cin>>weight;
		cout<<"请输入物品数量:";
		cin>>len;
	int *v = new int[len];
	int *w = new int[len];
    for (int i=0;i<len; i++)
	{
		v[i] = rand()%200 + 1;
		w[i] = rand()%(weight+10) + 1;
	}

	int *result = new int[len];
	for (int i=0; i<len; i++)
	{
		result[i] = 0;
	}
	double maxvalue = fractionalpackage(v, w, weight,0,len,result);
	cout<<"~~~~~~~~~~~~~~~~~所有物品~~~~~~~~~~~~~~~~~~~~~~~~"<<endl;
	for (int i =0; i<len;i++)
	{
			cout<<"物品号:"<<i<<"重量：" <<w[i]<< "价值："<<v[i]<<endl;
	}
	cout<<"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"<<endl;
	cout <<"背包能装的最大价值：" <<maxvalue<<endl;
	cout<<"~~~~~~~~~背包里的物品：~~~~~~~~~~~~~~~~~~~~~~~~~~~"<<endl;
	for (int i =0; i<len;i++)
	{
		if(result[i] != 0)
		{
			cout<<"物品号:"<<i<<"总重量：" <<w[i]<< "总价值："<<v[i]<<"放入背包中的重量："<<result[i]<<endl;
		}
	}
	delete[]result;

}
}