import { browser, by, element } from 'protractor';

describe('Family-Todo Login', function() {
    it('should have login', function() {
        browser.get('/login');
        expect(element(by.css('h2')).getText()).toEqual('Login'); 
    });


      it('should go redirect to the right page after writing wrong credentials', () => {
            browser.get('/login');
            expect(element(by.css('h2')).getText()).toEqual('Login');
        
            element(by.css('[name=username]')).sendKeys('valami');
            element(by.css('[name=password]')).sendKeys('va');
            element(by.css('[type=submit]')).click();
        
            expect(element(by.css('h2')).getText()).toEqual('Login');
          });
  });