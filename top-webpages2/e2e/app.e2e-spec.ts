import { TopWebpagesPage } from './app.po';

describe('top-webpages App', function() {
  let page: TopWebpagesPage;

  beforeEach(() => {
    page = new TopWebpagesPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
