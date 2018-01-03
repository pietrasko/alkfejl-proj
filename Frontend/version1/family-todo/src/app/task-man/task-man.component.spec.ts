import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskManComponent } from './task-man.component';

describe('TaskManComponent', () => {
  let component: TaskManComponent;
  let fixture: ComponentFixture<TaskManComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaskManComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaskManComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
