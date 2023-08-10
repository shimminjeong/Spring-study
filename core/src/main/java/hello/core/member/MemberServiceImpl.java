package hello.core.member;

import java.util.List;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }



    //////////////////////////

    public Double calculateMa(List<Stock> stocks, int period) {
        double total = 0;

        for(int i = stocks.size() - 1; i > stocks.size() - period - 1; i—) {
            total += stocks.get(i).getClose();
        }

        return total / period;
    }


    public List<Double> calculateDiff(String id, int period){
        List<Double> diffList={};
        for (int i=period;i<service.findByIdOrderByTradingDayAsc(id).size()-1;i++){

            diffList.add(service.findByIdOrderByTradingDayAsc(id).get(i).getClose()-
                    service.findByIdOrderByTradingDayAsc(id).get(i+1).getClose());
        }
        return diffList;
    }

    public double calculateAverage(List<Double> list,int period){
        double u = 0, d = 0, au = 0, ad = 0, rsi = 0;

        for (int i=0; i<list.size();i++){
            if (list.get(i) >0){
                u+=list.get(i);
            } else{
                d+=list.get(i);
            }
        }
        au=u/period;
        ad=d/period;
        rsi=au/(au+ad);
        return rsi;
    }




//    for (int i=0; i<diffList.size();i++){
//        if (diffList[i]>0){
//            u+=diffList[i];
//        } else{
//            d+=diffList[i];
//        }
//    }
//    au=u/n;
//    ad=d/n;
//
//    double rs=au/ad;
//    double rsi=au/(au+ad);

//    ////////////////////////////////
//
//
//    List<double> upList=diffList.clone();
//    List<double> downList=diffList.clone();
//
//    for (int i=0; i>diffList.size();i++){
//        if (upList[i]<0){
//            upList[i]=0;
//        }
//        if(downList[i]>0){
//            downList[i]=0;
//        }
//    }
//
//    int upSum = upList.stream().mapToInt(Integer::intValue).sum();
//    int downSum = downList.stream().mapToInt(Integer::intValue).sum();
//    double au=upSum/upList.size();
//    double ad=downSum/upList.size();
//    double rs=au/ad;
//    double rsi1=au/(au+ad);
//
//    for (int i=0;i<service.findByIdOrderByTradingDayAsc("1").get-1;i++){
//        List<double> diffList;
//        diffList.add(service.findByIdOrderByTradingDayAsc("1").get(i).getClose()-service.findByIdOrderByTradingDayAsc("1").get(i+1).getClose());
//    }






//
//    double bandWidth=wservice.findByIdOrderByTradingDayAsc("1").get(-1).getClose()-service.findById("1").getClose()
//    if (bandWidth > 0) {
//        bandWidth/N
//    }
}
