/**
 * https://leetcode.com/problems/basic-calculator-iv/submissions/
 */
class Solution {
    
    class Term implements Comparable<Term> {
        int coef;
        List<String> vars; 

        public Term(int n) {
            coef = n; 
            vars = new ArrayList(); 
        }

        public Term(String s) {
            coef = 1; 
            vars = new ArrayList();
            vars.add(s);
        }

        @Override
        public String toString() {
            return coef + varString();
        }

        public String varString() {
            Collections.sort(vars);
            
            return vars.stream().map(s -> "*" + s).reduce("", String::concat);
        }

        @Override
        public boolean equals(Object o) {
            return varString().equals(((Term)o).varString());
        }

        @Override
        public int compareTo(Term t) {
            if (vars.size() != t.vars.size()) {
                return t.vars.size() - vars.size(); 
            }
            
            return varString().compareTo(t.varString());
        }

        public Term multi(Term t) {
            Term result = new Term(coef);
            
            result.coef *= t.coef; 
            result.vars.addAll(vars);
            result.vars.addAll(t.vars);
            
            return result; 
        }
    }

    class Sequence {
        List<Term> terms; 

        public Sequence() {
            terms = new ArrayList();
        }

        public Sequence(int n) {
            terms = new ArrayList();
            terms.add(new Term(n));
        }

        public Sequence(String s) {
            terms = new ArrayList();
            terms.add(new Term(s));
        }

        public Sequence(Term t) {
            terms = new ArrayList();
            terms.add(t);
        }

        public Sequence add(Sequence sq) {
            Map<String, Term> sqMap = new HashMap();

            for (Term t : terms) {
                sqMap.put(t.varString(), t);
            }

            for (Term st : sq.terms) {
                if (sqMap.containsKey(st.varString())) {
                    sqMap.get(st.varString()).coef += st.coef;
                    
                    if (sqMap.get(st.varString()).coef == 0) {
                        terms.remove(sqMap.get(st.varString()));
                    }
                } else if (st.coef != 0){
                    terms.add(st);
                }
            }

            return this; 
        }

        public Sequence multi(Sequence sq) {
            Sequence result = new Sequence();

            for (final Term t : terms) {
                for (final Term t2 : sq.terms) {
                    result.add(new Sequence(t.multi(t2)));
                }
            }

            return result; 
        }
    }
    
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        final Map<String, Integer> evalMap = new HashMap<>();
        
        for (int j = 0; j < evalvars.length; j++) {
            evalMap.put(evalvars[j], evalints[j]);
        }
        
        final int[] i = new int[1];
        
        i[0] = 0;
        
        final Sequence finalSq = helper(expression, evalMap, i);
        final List<String> res = new ArrayList<>();
        
        Collections.sort(finalSq.terms);
        
        for (final Term t : finalSq.terms) {
            if (!t.toString().equals("0")) {
                res.add(t.toString());
            }
        }
        
        return res; 
    }
    
    Sequence helper(String e, Map<String, Integer> evalMap, int[] i) {
        Stack<Sequence> workingStack = new Stack();
        int flag = 1; 
        
        workingStack.push(new Sequence(0));
        
        while (i[0] < e.length()) {
            if (e.charAt(i[0]) == ' ') {
                i[0]++;
                continue;
            } else if (e.charAt(i[0]) == '(') {
                i[0]++;
                addToStack(workingStack, helper(e, evalMap, i), flag);
            } else if (e.charAt(i[0]) == ')') {
                break; 
            } else if (e.charAt(i[0]) == '*') {
                flag = 0;
            } else if (e.charAt(i[0]) == '+') {
                flag = 1;
            } else if (e.charAt(i[0]) == '-') {
                flag = -1;
            } else if (Character.isDigit(e.charAt(i[0]))) {
                int val = 0; 
                
                while (i[0] < e.length() && Character.isDigit(e.charAt(i[0]))) {
                    val = (val * 10) + (e.charAt(i[0]++) - '0');
                }
                
                i[0]--;
                addToStack(workingStack, new Sequence(val), flag);
            } else {
                String var = "";
                
                while (i[0] < e.length() && Character.isLowerCase(e.charAt(i[0]))) {
                    var += e.charAt(i[0]++);
                }
                
                i[0]--;
                addToStack(workingStack, evalMap.containsKey(var) ? new Sequence(evalMap.get(var)) : new Sequence(var), flag);
            }
            
            i[0]++;
        }
        
        Sequence result = new Sequence();
        
        while (!workingStack.isEmpty()) {
            result.add(workingStack.pop());
        }
        
        return result; 
    }
    
    void addToStack(Stack<Sequence> workingStack, Sequence sq, int flag) {
        if (flag == 0) {
            workingStack.push(workingStack.pop().multi(sq));
        } else {
            workingStack.push(sq.multi(new Sequence(flag)));
        }
    }
}