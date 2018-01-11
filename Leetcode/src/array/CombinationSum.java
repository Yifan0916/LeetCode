package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list =  new ArrayList<List<Integer>>();
        if (candidates.length==0) 
            return list;
        List<Integer> inner = new ArrayList<Integer>();
        Arrays.sort(candidates);
        
        recur(candidates,target, 0, inner, list);
        return list;
    }
    public void recur(int[] candidates, int target, int index, List<Integer> inner, List<List<Integer>> list) {
        if (target==0) {
            list.add(new ArrayList<Integer>(inner));   //target=0,鎰忓懗鐫�宸茬粡鎵惧埌涓�涓猚ombination锛屾墍浠ュ彲浠ユ坊鍔犺繘鍘伙紒
            return;
        }
        int prev=-1;
        for (int i=index;i<candidates.length;i++) { //涓�瀹氭敞鎰廼=index鏄垵濮嬪�硷紒锛侊紒锛佷笉鏄粠0寮�濮嬶紒锛佷笉鐒禼ombination涓島nique锛�
            if (candidates[i]>target) break; //娉ㄦ剰鍦ㄥ疄鐜颁腑for寰幆涓涓�姝ユ湁涓�涓垽鏂紝
                                             //閭ｄ釜鏄负浜嗗幓闄ら噸澶嶅厓绱犱骇鐢熼噸澶嶇粨鏋滅殑褰卞搷锛�
                                             //鍥犱负鍦ㄨ繖閲屾瘡涓暟鍙互閲嶅浣跨敤锛屾墍浠ラ噸澶嶇殑鍏冪礌涔熷氨娌℃湁浣滅敤浜嗭紝鎵�浠ュ簲璇ヨ烦杩囬偅灞傞�掑綊銆�
            if (prev!=-1 && prev==candidates[i]) continue;
            
            inner.add(candidates[i]);
            recur(candidates,target-candidates[i], i, inner, list);  //鍥犱负涓�鍏冪礌鍙敤寰堝娆★紝鎵�浠ヤ笉鏄痠+1銆�
            inner.remove(inner.size()-1);
            
            prev=candidates[i];
        }
    }
    
    public void recur_Update(int[] candidates, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> inn, int index) {
        if(target == 0) {res.add(new ArrayList<Integer>(inn)); return ;}
        //if(sum > target) return;
        for(int i=index; i<candidates.length; i++) {
            if(candidates[i] > target) break;
            while( i<candidates.length-1 && candidates[i] == candidates[i+1]) i++; //鍘婚櫎閲嶅锛侊紒锛�
            
            inn.add(candidates[i]);
            recur_Update(candidates, target-candidates[i], res, inn, i); 
            inn.remove(inn.size()-1);
            
            /*
             * Combination Sum II 鎶�46 浼犲叆鍙傛暟鍙樹负i+1锛� 鐒跺悗43琛屾斁鍒版澶勩��
             */
        }
    }
    /*
     * Combination Sum II 瑕佹眰姣忎釜鍏冪礌鍙兘鐢ㄤ竴娆°�傚氨鎶�31琛屼紶鍏ュ弬鏁板彉鎴恑+1锛屾妸鍏充簬prev 鐨勯兘drop.
     * 琛屽彉鎴愶細 if (i>index && candidates[i]==candidates[i-1]) continue;娉ㄦ剰杩欓噷杩樻槸瑕佸垽鏂拰鍓嶄竴涓厓绱犱笉鐩哥瓑锛屽惁鍒欎細鍑虹幇閲嶅combination銆�
     */
}
