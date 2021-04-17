package mathElements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 肖瑜
 */
public class Det implements Serializable {
    public double res = 0;
    public int sign = 0;
    public int level;
    int[] L=null, R=null;

    public void permute(ArrayList<Vec> A) {
        res = 0;
        level = A.size();
        List<Integer> output = new ArrayList<>();
        for (int i=0 ;i < level;i++) {
            output.add(i);
        }

        int n = level;
        backtrack(A, n, output, 0);
        L=null;
        R=null;
    }

    public void backtrack(ArrayList<Vec> A, int n, List<Integer> output, int first) {
        // 所有数都填完了
        if (first == n) {
            double temp = 1;
            for (int i = 0; i < A.size(); i++) {
                temp = temp * A.get(i).x[output.get(i)];
            }
            InverseNum(output);
            res += sign * temp;
            sign=0;
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(A, n, output, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public void InverseNum(List<Integer> output) {
        int left = 0, right = output.size()-1;
        if(L==null||L.length<=right+1){
            L = new int[right+1];
            R = new int[right+1];
        }
        int[] a=new int[right+1];
        for (int i=0;i<level;i++){
            a[i]=output.get(i);
        }
        merge(a, left, right);
        if(sign==0) {
            sign=1;
        } else {
            sign=-1;
        }
    }

    private void merge(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        merge(a, left, mid);
        merge(a, mid + 1, right);
        int i, j, k;
        for (i = left; i <= mid; i++) {
            L[i]=a[i];
        }
        for (; i <= right; i++) {
            R[i]=a[i];
        }
        for (k = left, i = left, j = mid + 1; k <= right; k++) {
            if (i <= mid && j <= right) {
                if (L[i] > R[j]) {
                    a[k] = R[j++];
                    sign = (sign+(mid - i + 1))%2;
//                    ans+=(mid-i+1); 逆序对个数
                } else {
                    a[k] = L[i++];
                }
            } else if (j <= right) {
                a[k] = R[j++];
            } else if (i <= mid) {
                a[k] = L[i++];
            }
        }
    }
}
