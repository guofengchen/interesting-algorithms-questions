#include <iostream>
using namespace std;

template <class T>
int getArrayLen(T & Array)
{
	return (sizeof(Array))/(sizeof(Array[0]));
}
void counting_sort (int maxEle, int a[], int b[], int len)
{
  int *c = new int[maxEle];
  for (int i =0; i<maxEle; i++)
  {
	  c[i] = 0;
  }
  for (int i =0; i<len; i++)
  {
	  c[a[i]] ++;
  }
  for (int i =1; i<maxEle ; i++)
  {
	  c[i] = c[i] + c[i-1];
  }
  for (int i = len-1; i>=0; i--){
      b[c[a[i]]-1] = a[i];
	  c[a[i]]--;
  }

}
void counting_sort( int maxEle, int a[],int len)
{
	int *b = new int[len];
	for (int i =0; i<len ; i++)
    {
	  b[i] = a[i];
    }
	counting_sort (maxEle, b, a, len);

}
void main(){
	int max =5;
	int a[] = {0,0,4,4,4,4,1,2,3,1,2,3};
	int len = getArrayLen(a);
	counting_sort(max , a, len);
	for (int i =0; i<len ; i++)
    {
	  cout<<a[i]<<endl;
    }
	getchar();

}