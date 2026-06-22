package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> details) {

        Map<String, Integer> map = new HashMap<>();

        int n = details.size();
        DisJointSet set = new DisJointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < details.get(i).size(); j++) {
                String mail = details.get(i).get(j);
                if (!map.containsKey(mail)) {
                    map.put(mail, i);
                } else {
                    set.unionByRank(i, map.get(mail));
                }

            }

        }

        ArrayList<String>[] mergedMail = new ArrayList[n];

        for (int i = 0; i < mergedMail.length; i++) {
            mergedMail[i] = new ArrayList<>();

        }

        for (Map.Entry<String, Integer> it : map.entrySet()) {
            String mail = it.getKey();
            int node = set.findUp(it.getValue());
            mergedMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail[i].isEmpty())
                continue;

            Collections.sort(mergedMail[i]);

            List<String> temp = new ArrayList<>();
            temp.add(details.get(i).get(0));

            for (String mail : mergedMail[i]) {
                temp.add(mail);
            }
            ans.add(temp);
        }

        // Sort final answer
        ans.sort((a, b) -> a.get(0).compareTo(b.get(0)));
        return ans;

    }

    public static void main(String[] args) {

    }

}

class DisJointSet {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisJointSet(int nodes) {
        for (int i = 0; i <= nodes; i++) {
            rank.add(0);
            parent.add(i);
        }

    }

    public int findUp(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        parent.set(node, findUp(parent.get(node)));
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUp(u);
        int ulp_v = findUp(v);
        if (ulp_u == ulp_v) {
            return;
        }
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);

        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
    }

}
