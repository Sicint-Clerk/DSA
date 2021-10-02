#include<bits/stdc++.h>
using namespace std;
typedef long long int ll;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    ll n;
    cin>>n;
    ll a[n];
    for(ll i=0;i<n;i++)
    {
        cin>>a[i];
    }
    ll l=0,r=n-1;
    while(l<r)
    {
        ll temp=a[l];
        a[l]=a[r];
        a[r]=temp;
        r--;
        l++;
    }
    for(ll i=0;i<n;i++)
    {
        cout<<a[i]<<" ";
    }

    return 0;
}
