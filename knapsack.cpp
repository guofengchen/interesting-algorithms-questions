//Author: chenguofeng08qh@gmail.com

#include <iostream>
using namespace std;

template <class T>
int getArrayLen(T & Array)
{
	return (sizeof(Array))/(sizeof(Array[0]));
}


int package_01 (int v[], int w[], int weight, int len, int result[])
{

	int **a = new int*[len+1];
    for(int i = 0; i < len+1; ++i) {
    a[i] = new int[weight+1];
    }

	for (int i =0; i<weight+1; i++)
	{
		a[0][i] = 0;
	}
	for (int i =0; i<len+1; i++)
	{
		a[i][0] = 0;
	}
	for (int i =1; i< len+1 ; i++)
		for (int j = 1; j< weight+1; j++)
		{
			int tmp1 = a[i-1][j];
			int tmp2 = 0;
			if (j -w[i-1] >=0){ tmp2 = a[i-1][j-w[i-1]] + v[i-1];} 

			a[i][j] = tmp1>tmp2 ? tmp1:tmp2;
		}
	int l = len;
	int wei = weight;
	while(l > 0)
	{
		if(a[l][wei] == a[l-1][wei]){
			result[l-1] = 0;
			l--;}
		else{
			result[l-1] = 1;
			wei = wei - w[l-1];
			l--;
		}
	}

	int re = a[len][weight];
	for(int i = 0; i < len+1; ++i) {
    delete [] a[i];
    }
    delete [] a;
	return re;
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
		v[i] = rand()%200;
		w[i] = rand()%(weight+10);
	}

	int *result = new int[len];
	int maxvalue = package_01(v, w, weight,len,result);
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
		if(result[i] ==1)
		{
			cout<<"物品号:"<<i<<"重量：" <<w[i]<< "价值："<<v[i]<<endl;
		}
	}
	delete[]result;

}
}