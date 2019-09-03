package Bishi;

import java.util.HashMap;
import java.util.Scanner;

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        ListNode head = new ListNode(Math.abs(Integer.parseInt(s[0])));
        ListNode cur = head;
        for (int i = 0; i < s.length; i++) {
            int num = Integer.parseInt(s[i]);
            cur.next = new ListNode(Math.abs(num));
            cur = cur.next;
        }
        ListNode node = deleteDuplication(head);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null)
            return head;
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode firstNode = new ListNode(-1);
        firstNode.next = head;
        ListNode pre = firstNode;
        ListNode cur = firstNode.next;
        while (pre != null && pre.next != null) {
            if (map.containsKey(cur.val)) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                map.put(cur.val, 1);
                pre = cur;
                cur = cur.next;
            }
        }
        return firstNode.next;
    }
}




//#include<stdio.h>
//#include<math.h>
//
//void swap(int* a, int* b){
//    int tmp = *a;
//    *a = *b;
//    *b = tmp;
//}
//
//void PerDown(int A[], int i, int N){
//    int left;
//    int tmp;
//    for(tmp = A[i]; 2*i < N; i = left){
//        left = 2*i + 1;
//        if(left != N-1 && A[left + 1] > A[left]){
//            ++left;
//        }
//        if(tmp < A[left]){
//            A[i] = A[left];
//        } else{
//            break;
//        }
//    }
//    A[i] = tmp;
//}
//
//void heapSort(int A[], int N){
//    int i;
//    for(i = N -1; i > 0; i--){
//        PerDown(A, i, N);
//    }
//    for(i = N -1; i > 0; i--){
//        swap(&A[0], &A[i]);
//        PerDown(A, 0, i);
//    }
//}
//
//int main(){
//    int N;
//    scanf("%d", &N);
//    int arr[N];
//    for(int i = 0; i < N; i++){
//        scanf("%d", &arr[i]);
//    }
//    int heapSize = ceil(N * 0.001);
//    heapSort(arr, heapSize);
//    for(int i = heapSize; i < N; i++){
//        if(arr[i] > arr[0]){
//            swap(&arr[0], &arr[i]);
//            PerDown(arr, 0, i);
//        }
//    }
//    for(int i = 0; i < heapSize; i++){
//        printf("%d\n", arr[i]);
//    }
//    return 0;
//}