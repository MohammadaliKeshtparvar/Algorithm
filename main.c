#include <stdio.h>

void ax(int *o, int *p){
    int temp;
    temp = *p;
    *p = *o;
    *o = temp;
}


void sort(int a[], int size){
    for(int i=0; i<size; i++){
        for(int j=i; j<size; j++){
            if(a[i] > a[j]){
                ax(&a[i], &a[j]);
            }
        }

    }
}

void subset(int arr[], int data[], int start, int end, int index, int r)

{

    int j, i;

    if (index == r) {
        printf("{ ");
        sort(data, r);
        for (j = 0; j < r; j++)

            printf("%d ", data[j]);
        printf("}");
        printf("\n");

        return;

    }
    sort(arr, r);
    for (i = start; i <= end && end - i + 1 >= r - index; i++)

    {

        data[index] = arr[i];

        subset(arr, data, i+1, end, index+1, r);

    }

}




void printsubset(int arr[], int n, int r)

{

    int data[r];
    //sort(data, r);

    subset(arr, data, 0, n - 1, 0, r);

}

int main()
{
    int arr[20], n, i;


    scanf("%d", &n);

    for (  i = 0; i < n; i++){
        scanf("%d", &arr[i]);
    }

    for(int i=0; i<=n; i++){
        printsubset(arr, n, i);
    }


    return 0;

}
