import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-faq',
  templateUrl: './faq.page.html',
  styleUrls: ['./faq.page.scss'],
})
export class FaqPage implements OnInit {

  public faqs = [];

  constructor() { }

  ngOnInit() {
    this.faqs = [
      {
        q : "What is “Garbh Vigyan” App?",
        a : `This application will work from Day 1 of pregnancy. This will provide activity and material day to day basis on this application.`,
        expanded : false
      },
      {
        q : "Is this application will guide medically?",
        a : 'No. For all medical related query and your current problem, you must consult with your doctor only.',
        expanded : false
      },
      {
        q : `Is this internet required for this application?`,
        a : `Yes.`,
        expanded : false
      },
      {
        q : `Can I share or gift this app to other?`,
        a : `Yes. Share option is available in mobile application.`,
        expanded : false
      },
      {
        q : `Is there any fix time to use this app?`,
        a : `No. Content in the application are update as the calendar date changed. So you must have
        to visit the application before that.`,
        expanded : false
      },
      {
        q : `What to do if any of content, we need to view or listen repeatedly?`,
        a : `You can save the content and refer in future, but there will be limitation of content to be
        marked as save.`,
        expanded : false
      },
      {
        q : `What to do if we didn’t understood of the content available?`,
        a : `You can write in “ask a Question” section. Our expert team will contact you soon.`,
        expanded : false
      },
      {
        q : `If I have 2 months of pregnancy when I join the application. Can I get the previous data at time
        of joining?`,
        a : `No. The activity in app are designed in day basis and scientifically as per development of
        unborn child in the womb, so don’t worry.`,
        expanded : false
      },
      {
        q : `If I am working women, can I spend that much time on the app?`,
        a : `We designed app in such a way that audible data will be available for each section. So you
        can easily listen while doing work too.`,
        expanded : false
      },
      {
        q : `If I want to Sanskar, whom should I contact?`,
        a : `Use “Sanskar Request” option and fill the basic details. Nearby yagyacharya will contact and
        perform yagya at your place.`,
        expanded : false
      },
      {
        q : `Why pregnant lady family information required here?`,
        a : `This application will update the family members about the development of child
        scientifically and inform them to taking care of yours. It will also help them meditation, dhyan
        and other so many knowledge.`,
        expanded : false
      },
      {
        q : `Can I share the content of the app?`,
        a : `No.`,
        expanded : false
      }
    ]
  }
  
  expandItem(faq): void {
    if (faq.expanded) {
      faq.expanded = false;
    } else {
      this.faqs.map(f => {
        if (faq == f) {
          f.expanded = !f.expanded;
        } else {
          f.expanded = false;
        }
        return f;
      });
    }
  }

}
